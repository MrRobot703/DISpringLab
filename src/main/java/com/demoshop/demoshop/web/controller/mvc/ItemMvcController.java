package com.demoshop.demoshop.web.controller.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Slf4j
@Controller
public class ItemMvcController {

    @GetMapping({"/item", "/item{id}"})
    public String getItems(@PathVariable(required = false) Long id) {
        if (id == null) {
            log.info("Referred to the home page ");
            return "item/itemList";
        } else {
            log.info("Referred to the item page");
            return "item/item" + id;
        }
    }
}



