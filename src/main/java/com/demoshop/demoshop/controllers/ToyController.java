package com.demoshop.demoshop.controllers;

import com.demoshop.demoshop.viewModel.PropertyViewModel;
import com.demoshop.demoshop.viewModel.PropertyViewModel.Type;
import com.demoshop.demoshop.viewModel.ToyViewModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/toys")
public class ToyController {

    //#TODO replace mock model
    @ModelAttribute
    public void addProductsToModel(Model model) {
        List<PropertyViewModel> ingredients = Arrays.asList(
                new PropertyViewModel("FLTO", "Spider-man", Type.COOL),
                new PropertyViewModel("COTO", "Batman", Type.COOL),
                new PropertyViewModel("GRBF", "Fluffy Bear", Type.AWESOME),
                new PropertyViewModel("CARN", "Super Duper Toy", Type.AWESOME),
                new PropertyViewModel("TMTO", "PC", Type.BORING),
                new PropertyViewModel("LETC", "PS5", Type.BORING),
                new PropertyViewModel("CHED", "Nothing", Type.STUPID),
                new PropertyViewModel("JACK", "Jack Daniels", Type.STUPID),
                new PropertyViewModel("SLSA", "Rubber Toy", Type.SAUCY),
                new PropertyViewModel("SRCR", "Saucy Toy", Type.SAUCY)
        );
        Type[] types = Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showProductsForm(Model model) {
        model.addAttribute("toy", new ToyViewModel());
        return "products";
    }

    @PostMapping
    public String processProduct(@Valid @ModelAttribute("toy") ToyViewModel toyViewModel, Errors errors) {
        if (errors.hasErrors()) {
            return "products";
        }
        log.info("Processing product: " + toyViewModel);
        return "redirect:/orders/current";
    }

    private List<PropertyViewModel> filterByType(List<PropertyViewModel> ingredients, Type type) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
