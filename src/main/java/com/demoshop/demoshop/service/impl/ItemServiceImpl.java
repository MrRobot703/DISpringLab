package com.demoshop.demoshop.service.impl;

import com.demoshop.demoshop.data.dto.simple.ItemDto;
import com.demoshop.demoshop.data.entity.ItemEntity;
import com.demoshop.demoshop.repositories.ItemRepository;
import com.demoshop.demoshop.service.api.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("actualEntityService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itRepository;


    public ItemDto convertToItemDto(ItemEntity itEntity) {
        ItemDto tmpDto = new ItemDto();
        tmpDto.setName(itEntity.getName());
        tmpDto.setPrice(itEntity.getPrice());
        return tmpDto;
    }


    public List<ItemDto> getAllItems() {
        List<ItemDto> items = new ArrayList();
        for (ItemEntity item1 : itRepository.findAll()) {
            items.add(convertToItemDto(item1));
        }
        return items;
    }

    public ItemEntity getItemById(Long id) {
        return itRepository.findById(id).get();
    }

    @Override
    public String getDescriptionById(Long id) {
        return getItemById(id).getDescription();
    }

    public ItemEntity save(ItemDto dto) {
        ItemEntity entity = new ItemEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return itRepository.save(entity);
    }

    public void delete(Long id) {
        itRepository.deleteById(id);
    }


    public ItemEntity saveOrUpdate(ItemEntity item) {
        if (itRepository.findById(item.getId()).isPresent()) {
            ItemEntity tmpEntity = itRepository.findById(item.getId()).get();
            tmpEntity.setPrice(item.getPrice());
            tmpEntity.setName(item.getName());
            return itRepository.save(tmpEntity);
        } else
            return itRepository.save(item);
    }
}



