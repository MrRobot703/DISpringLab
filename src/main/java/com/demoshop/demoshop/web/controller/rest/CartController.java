package com.demoshop.demoshop.web.controller.rest;

import com.demoshop.demoshop.data.dto.simple.ItemDto;
import com.demoshop.demoshop.model.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CartController {

    @Autowired
    private Cart cart;

    @PostMapping("/addItemToCart")
    public void addItem(@RequestBody ItemDto itemDto) {
        cart.add(itemDto);
        log.info(cart.toString());
    }

    @PostMapping("/removeItemFromCart")
    public void removeItem(@RequestBody ItemDto itemDto) {
        cart.remove(itemDto);
        log.info(cart.toString());
    }

    @GetMapping("/getItemsInCart")
    public List<ItemDto> getItemsInCart() {
        return cart.getItems();
    }
}
