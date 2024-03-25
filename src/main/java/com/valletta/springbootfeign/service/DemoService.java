package com.valletta.springbootfeign.service;

import com.valletta.springbootfeign.common.dto.BaseRequestInfo;
import com.valletta.springbootfeign.common.dto.BaseResponseInfo;
import com.valletta.springbootfeign.feign.client.DemoFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DemoService {

    private final DemoFeignClient client;

    public String get() {
        ResponseEntity<BaseResponseInfo> response = client.callGet("CustomHeader", "CustomName", 1L);

        log.info("# Name: {}", response.getBody().getName());
        log.info("# Age: {}", response.getBody().getAge());
        log.info("# Header: {}", response.getBody().getHeader());

        return "get";
    }

    public String post() {
        BaseRequestInfo baseRequestInfo = BaseRequestInfo.builder()
            .name("customPostName")
            .age(3L)
            .build();
        ResponseEntity<BaseResponseInfo> response = client.callPost("CustomHeader", baseRequestInfo);

        log.info("# Name: {}", response.getBody().getName());
        log.info("# Age: {}", response.getBody().getAge());
        log.info("# Header: {}", response.getBody().getHeader());

        return "post";
    }

    public String errorDecoder() {
        client.callErrorDecoder();

        return "errorDecoder";
    }
}
