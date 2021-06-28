package com.demoshop.demoshop.web.controller.mvc;

import com.demoshop.demoshop.data.dto.simple.ItemDto;
import com.demoshop.demoshop.data.entity.ItemEntity;
import com.demoshop.demoshop.model.Cart;
import com.demoshop.demoshop.model.Order;
import com.demoshop.demoshop.service.api.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import com.demoshop.demoshop.web.viewModel.OrderViewModel;

import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Cart cart;

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("productOrder", new OrderViewModel());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("productOrder") OrderViewModel orderViewModel, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        Order order = createOrder(orderViewModel);
        orderService.submit(order);
        log.info("Order submitted: " + order);
        return "redirect:/";
    }

    private Order createOrder(OrderViewModel orderViewModel) {
        Order order = new Order();
        order.setName(orderViewModel.getName());
        order.setCcNumber(orderViewModel.getCcNumber());
        order.setCcCVV(orderViewModel.getCcCVV());
        order.setCcExpiration(orderViewModel.getCcExpiration());
        order.setCity(orderViewModel.getCity());
        order.setStreet(order.getStreet());

        order.setItems(cart.getItems()
                .stream()
                .map(this::convertDtoToEntity)
                .collect(Collectors.toList())
        );

        return order;
    }

    private ItemEntity convertDtoToEntity(ItemDto dto) {
        ItemEntity entity = new ItemEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return entity;
    }
}
