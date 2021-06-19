package com.demoshop.demoshop.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ItemMvcController {

    @GetMapping({"/item", "/item{id}"})
    public String getItems(@PathVariable(required = false) Long id) {
        if (id == null)
            return "item/itemList";
        else
            return "item/item" + id;
    }


//    @PostMapping({"/test"})
//    public String getTv(@RequestBody Long id) {
//        return "item/item_"+id;
//    }
}




