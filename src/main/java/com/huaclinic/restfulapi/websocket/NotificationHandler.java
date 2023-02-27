package com.huaclinic.restfulapi.websocket;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import com.huaclinic.restfulapi.util.JwtUtils;
import com.huaclinic.restfulapi.models.Reminder;
public class NotificationHandler extends TextWebSocketHandler{
    private static Set<Pair<WebSocketSession, String>> subscribers = new HashSet<>();
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();
        String username = jwtUtils.getUsernameFromJwtToken(payload);
        Iterator<Pair<WebSocketSession, String>> itr = subscribers.iterator();
        while(itr.hasNext()) {
            Pair<WebSocketSession, String> p = itr.next();
            if(p.getSecond().equals(username)) {
                subscribers.remove(p);
                continue;
            }
            if(p.getFirst().getId().equals(session.getId())) {
                subscribers.remove(p);
                subscribers.add(Pair.of(p.getFirst(), username));
                break;
            }
        }
        itr = subscribers.iterator();
        while(itr.hasNext()) {
            Pair<WebSocketSession, String> p = itr.next();
            System.out.println(p.getFirst());
            System.out.println(p.getSecond());
        }
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Add the new WebSocket session to the list of sessions
        
        subscribers.add(Pair.of(session, ""));
        

        // Send a welcome message to the new WebSocket session
        // session.sendMessage(new TextMessage("Welcome to the WebSocket server!"));
    }

    public static void pushNotification(String username, Reminder reminder) throws IOException {
        Iterator<Pair<WebSocketSession, String>> itr = subscribers.iterator();
        while(itr.hasNext()) {
            Pair<WebSocketSession, String> p = itr.next();
            System.out.println(String.format("%s ~ %s", p.getSecond(), username));
            if(p.getSecond().equals(username)) {
                TextMessage tm = new TextMessage(reminder.getDescription());
                p.getFirst().sendMessage(tm);
                break;
            }
        }
    }
    
}
