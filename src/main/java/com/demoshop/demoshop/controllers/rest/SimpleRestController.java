package com.demoshop.demoshop.controllers.rest;

import com.demoshop.demoshop.data.dto.simple.SimpleRequestDto;
import com.demoshop.demoshop.data.dto.simple.SimpleResponseDto;
import com.demoshop.demoshop.service.api.SimpleService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api("Тестовый контроллер для проверки приложения")
public class SimpleRestController {

    private final SimpleService simpleService;

    @PostMapping("/check_it")
    public SimpleResponseDto checkIt(@RequestBody SimpleRequestDto requestDto) {
        return simpleService.concat(requestDto);
    }

}
