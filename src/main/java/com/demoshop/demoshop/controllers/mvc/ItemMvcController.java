package com.demoshop.demoshop.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ItemMvcController {

    @GetMapping({"/item"})
    public String index() {
        return "item/itemList";
    }
}


