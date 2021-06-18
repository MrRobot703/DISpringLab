package com.demoshop.demoshop.web.controller.rest.simple;

import com.demoshop.demoshop.data.dto.simple.SimplePetDto;
import com.demoshop.demoshop.data.dto.simple.SimpleRequestDto;
import com.demoshop.demoshop.data.dto.simple.SimpleResponseDto;
import com.demoshop.demoshop.service.api.SimplePetService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api("Тестовый контроллер для проверки приложения")
public class SimpleRestController {

    private final SimplePetService simpleService;

    @PostMapping("/check_it")
    public SimpleResponseDto checkIt(@RequestBody SimpleRequestDto requestDto) {
        return simpleService.concat(requestDto);
    }

    @PostMapping("/find/petsById")
    public SimplePetDto findPetsById(@RequestParam Long id) throws Exception {
        return simpleService.findPetById(id);
    }

    @GetMapping("/find/pets")
    public List<SimplePetDto> findPets() {
        return simpleService.findAllPets();
    }

}
