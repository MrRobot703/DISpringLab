package com.demoshop.demoshop.service.api;

import com.demoshop.demoshop.data.entity.ItemEntity;
import com.demoshop.demoshop.data.dto.simple.ItemDto;

import java.util.List;

public interface ItemService {
    ItemEntity save(ItemDto dto);
    List<ItemDto> getAllItems();
    ItemEntity saveOrUpdate(ItemEntity item);
    ItemDto convertToItemDto(ItemEntity itEntity);
    ItemEntity getItemById(Long id);
    void delete(Long id);
    void deleteByName(String name);

}