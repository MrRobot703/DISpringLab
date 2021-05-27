package com.demoshop.demoshop.data.dto.simple;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SimpleResponseDto {
    String message;

    public SimpleResponseDto(SimpleRequestDto requestDto) {
        this.message = "Участник практикума: " + requestDto.firstName + " " + requestDto.lastName + " запустил бекенд";
    }
}
