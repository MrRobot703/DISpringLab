package com.backend.service;

import com.backend.dto.itemDto;
import com.backend.entity.itemEntity;

import java.util.List;

public interface entityService {
    itemEntity save(itemDto dto);
    List<itemDto> getAllItems();
    itemEntity update(itemEntity item);
    itemDto convertToItemDto(itemEntity itEntity);
    itemEntity getItemById(Long id);
    void delete(Long id);


}