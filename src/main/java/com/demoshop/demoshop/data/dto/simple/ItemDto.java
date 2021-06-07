package com.demoshop.demoshop.data.dto.simple;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private String name;
    private double price;

    public ItemDto() {}

}
