package com.huaclinic.restfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huaclinic.restfulapi.services.CustomUserDetails;
import com.huaclinic.restfulapi.util.JwtUtils;
import com.huaclinic.restfulapi.payload.request.LoginReq;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import com.huaclinic.restfulapi.payload.response.LoginRes;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/signin")
    public ResponseEntity<LoginRes> authSignIn(@RequestBody LoginReq loginReq) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
        context.setAuthentication(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) context.getAuthentication().getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> permissions = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(
                new LoginRes(userDetails.getId(), userDetails.getUsername(), userDetails.getName(), permissions));
    }

    @PostMapping("/login")
    public String login() {
        return "This is Login.";
    }
}
