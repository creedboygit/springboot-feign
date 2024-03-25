package com.valletta.springbootfeign.feign.config;

import com.valletta.springbootfeign.feign.interceptor.FeignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoFeignConfig {

    @Bean
    public FeignInterceptor feignInterceptor() {
        return FeignInterceptor.of();
    }
}
