package com.demoshop.demoshop.model;

import com.demoshop.demoshop.data.dto.simple.ItemDto;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@SessionScope
public class Cart {

    private List<ItemDto> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(ItemDto item) {
        this.items.add(item);
    }

    public void remove(ItemDto item) {
        this.items.remove(item);
    }

    public void emptyCart() {
        this.items = new ArrayList<>();
    }
}
