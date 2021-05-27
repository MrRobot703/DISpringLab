package com.demoshop.demoshop.controllers;

import com.demoshop.demoshop.data.dto.simple.SimpleRequestDto;
import com.demoshop.demoshop.data.dto.simple.SimpleResponseDto;
import com.demoshop.demoshop.service.api.SimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final SimpleService simpleService;

    @PostMapping("/check_it")
    public SimpleResponseDto checkIt(SimpleRequestDto requestDto) {
        return simpleService.concat(requestDto);
    }

}
