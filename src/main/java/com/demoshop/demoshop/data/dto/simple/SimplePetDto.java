package com.demoshop.demoshop.data.dto.simple;

import com.demoshop.demoshop.data.entity.SimplePet;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SimplePetDto {
    private Long id;
    private String name;
    private List<String> toys;

    public SimplePetDto(SimplePet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.toys = pet.getToys().stream().map(toy -> toy.getName()).collect(Collectors.toList());
    }
}
