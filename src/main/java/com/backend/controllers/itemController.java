package com.backend.controllers;

import com.backend.dto.itemDto;
import com.backend.entity.itemEntity;
import com.backend.service.entityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO:exceptions

@RestController
public class itemController {

    @Autowired
    @Qualifier("actualEntityService")
    entityService entService;

    @GetMapping("/test")
    public String sayHello() {
        return "Hello, world!";
    }

    @PostMapping("/saveItem")
    public String sayItemByPost(@RequestBody itemDto item) {
        Object obj = entService.save(item);
        return obj.toString();
    }

    @GetMapping("/getAllItems")
    public List<itemDto> getAllItems() {
        return entService.getAllItems();
    }

    @PostMapping("/getItemById")
    public itemEntity getItemById(@RequestBody Long id) {
        return entService.getItemById(id);
    }

    @PostMapping("/deleteItem")
    public void deleteItem(@RequestBody Long id) {
        entService.delete(id);
    }

    @PutMapping("/updateItem")
    public void updateItem(@RequestBody itemEntity item) {
        entService.update(item);
    }


}
