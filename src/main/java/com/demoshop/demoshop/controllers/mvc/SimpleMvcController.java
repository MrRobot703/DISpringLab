package com.demoshop.demoshop.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SimpleMvcController {

    @GetMapping("/mvc")
    public ModelAndView modelAndView() {
        Map<String, String> model = new HashMap<>();
        model.put("shopName", "Demo Shop");
        return new ModelAndView("modelExample", model);
    }

    @GetMapping({"/simple"})
    public String index() {
        return "simple/simplePetList";
    }
}
