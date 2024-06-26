package com.valletta.springbootfeign.controller;

import com.valletta.springbootfeign.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/get")
    public String getController() {
        return demoService.get();
    }

    @GetMapping("/post")
    public String postController() {
        return demoService.post();
    }

    @GetMapping("/error")
    public String errorDecoderController() {
        return demoService.errorDecoder();
    }
}
