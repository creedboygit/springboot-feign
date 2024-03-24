package com.valletta.springbootfeign.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DemoService {

    public String get() {
        return "get";
    }
}
