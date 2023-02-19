package com.huaclinic.restfulapi.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;


/**
 * RequestResponseFilter
 */
@Configuration
public class RequestResponseFilter {
    @Bean
    public CommonsRequestLoggingFilter RequestFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        return filter;
    }
}
