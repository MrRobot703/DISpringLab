package com.demoshop.demoshop.service.api;

import com.demoshop.demoshop.data.dto.simple.SimpleRequestDto;
import com.demoshop.demoshop.data.dto.simple.SimpleResponseDto;

public interface SimpleService {
    SimpleResponseDto concat(SimpleRequestDto requestDto);
}
