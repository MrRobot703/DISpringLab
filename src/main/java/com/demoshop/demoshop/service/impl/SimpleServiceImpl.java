package com.demoshop.demoshop.service.impl;

import com.demoshop.demoshop.data.dto.simple.SimpleRequestDto;
import com.demoshop.demoshop.data.dto.simple.SimpleResponseDto;
import com.demoshop.demoshop.service.api.SimpleService;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService {
    @Override
    public SimpleResponseDto concat(SimpleRequestDto requestDto) {
        return new SimpleResponseDto(requestDto);
    }
}
