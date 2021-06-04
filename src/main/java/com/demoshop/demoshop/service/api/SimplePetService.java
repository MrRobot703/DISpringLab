package com.demoshop.demoshop.service.api;

import com.demoshop.demoshop.data.dto.simple.SimplePetDto;
import com.demoshop.demoshop.data.dto.simple.SimpleRequestDto;
import com.demoshop.demoshop.data.dto.simple.SimpleResponseDto;

public interface SimplePetService {
    SimpleResponseDto concat(SimpleRequestDto requestDto);

    SimplePetDto findPetById(Long id) throws Exception;
}