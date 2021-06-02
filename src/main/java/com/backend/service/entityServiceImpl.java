package com.backend.service;

import com.backend.dto.itemDto;
import com.backend.entity.itemEntity;
import com.backend.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("actualEntityService")
public class entityServiceImpl implements entityService {

    @Autowired
    itemRepository itRepository;


    public itemDto convertToItemDto(itemEntity itEntity) {
        itemDto tmpDto = new itemDto();
        tmpDto.setName(itEntity.getName());
        tmpDto.setPrice(itEntity.getPrice());
        return tmpDto;
    }


    public List<itemDto> getAllItems() {
        List<itemDto> items = new ArrayList();
        for (itemEntity item1 : itRepository.findAll()) {
            items.add(convertToItemDto(item1));
        }
        return items;
    }

    public itemEntity getItemById(Long id) {
        return itRepository.findById(id).get();
    }

    public itemEntity save(itemDto dto) {
        itemEntity entity = new itemEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return itRepository.save(entity);
    }

    public void delete(Long id) {
        itRepository.deleteById(id);
    }

    //TODO:change signature to Dto

    public itemEntity update(itemEntity item) {
        if (itRepository.findById(item.getId()).isPresent()) {
            itemEntity tmpEntity = itRepository.findById(item.getId()).get();
            tmpEntity.setPrice(item.getPrice());
            tmpEntity.setName(item.getName());
            return itRepository.save(tmpEntity);
        } else
            return itRepository.save(item);
    }
}



