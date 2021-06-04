package com.demoshop.demoshop.service.impl;

import com.demoshop.demoshop.data.dto.simple.SimplePetDto;
import com.demoshop.demoshop.data.dto.simple.SimpleRequestDto;
import com.demoshop.demoshop.data.dto.simple.SimpleResponseDto;
import com.demoshop.demoshop.data.entity.SimplePet;
import com.demoshop.demoshop.data.repository.SimplePetRepository;
import com.demoshop.demoshop.exceptions.PetNotFoundByIdException;
import com.demoshop.demoshop.service.api.SimplePetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimplePetServiceImpl implements SimplePetService {

    private final SimplePetRepository simplePetRepository;

    @Override
    public SimpleResponseDto concat(SimpleRequestDto requestDto) {
        return new SimpleResponseDto(requestDto);
    }

    @Override
    public SimplePetDto findPetById(Long id) throws Exception {
        Optional<SimplePet> entity = simplePetRepository.findById(id);
        if (entity.isPresent()) {
            return new SimplePetDto(entity.get());
        }
        else {
            throw new PetNotFoundByIdException(id);
        }
    }
}
