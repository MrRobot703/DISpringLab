package com.demoshop.demoshop.data.dto.simple;

import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private double price;
    private String description;

    public ItemDto() {}

}
