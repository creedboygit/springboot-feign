package com.valletta.springbootfeign.service;

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

    private final DemoFeignClient demoFeignClient;

    public String get() {
        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("CustomHeader", "CustonName", 1L);

        log.info("# Name: {}", response.getBody().getName());
        log.info("# Age: {}", response.getBody().getAge());
        log.info("# Header: {}", response.getBody().getHeader());

        return "get";
    }
}
