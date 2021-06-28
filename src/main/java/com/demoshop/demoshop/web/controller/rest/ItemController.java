package com.demoshop.demoshop.web.controller.rest;

import com.demoshop.demoshop.data.dto.simple.ItemDto;
import com.demoshop.demoshop.data.entity.ItemEntity;
import com.demoshop.demoshop.service.api.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO:exceptions

@RestController
public class ItemController {

    @Autowired
    @Qualifier("actualEntityService")
    ItemService entService;

    @GetMapping("/test")
    public String sayHello() {
        return "Hello, world!";
    }

    @PostMapping("/saveItem")
    public String sayItemByPost(@RequestBody ItemDto item) {
        Object obj = entService.save(item);
        return obj.toString();
    }

    @GetMapping("/getAllItems")
    public List<ItemDto> getAllItems() {
        return entService.getAllItems();
    }

    @PostMapping("/getItemById")
    public ItemEntity getItemById(@RequestBody Long id) {
        return entService.getItemById(id);
    }

    @PostMapping("/deleteItemById")
    public void deleteItemById(@RequestBody Long id) {
        entService.delete(id);
    }

    @PostMapping("/deleteItem")
    public void deleteItem(@RequestBody ItemDto itemDto) {
        entService.deleteByName(itemDto.getName());
    }

    @PutMapping("/updateItem")
    public void updateItem(@RequestBody ItemEntity item) {
        entService.saveOrUpdate(item);
    }


}
