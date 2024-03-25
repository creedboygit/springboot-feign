package com.valletta.springbootfeign.controller;

import com.valletta.springbootfeign.common.dto.BaseRequestInfo;
import com.valletta.springbootfeign.common.dto.BaseResponseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/target-server")
public class TargetController {

    @GetMapping("/get")
    public BaseResponseInfo demoGet(@RequestHeader("CustomHeaderName") String header,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Long age) {
        return BaseResponseInfo.builder()
            .header(header)
//            .name(name)
            .name(name + " from target server")
            .age(age)
            .build();
    }

    @PostMapping("/post")
    public BaseResponseInfo demoPost(@RequestHeader("CustomHeaderName") String header,
                                     @RequestBody BaseRequestInfo body) {
        return BaseResponseInfo.builder()
            .header(header)
            .name(body.getName())
            .age(body.getAge())
            .build();
    }

    @GetMapping("/error")
    public ResponseEntity<BaseResponseInfo> demoErrorDecoder() {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
