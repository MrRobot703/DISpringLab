package com.demoshop.demoshop.web.controller.mvc;

import com.demoshop.demoshop.data.dto.simple.ItemDto;
import com.demoshop.demoshop.data.entity.ItemEntity;
import com.demoshop.demoshop.model.Cart;
import com.demoshop.demoshop.model.Order;
import com.demoshop.demoshop.model.Role;
import com.demoshop.demoshop.model.User;
import com.demoshop.demoshop.service.api.AuthenticationService;
import com.demoshop.demoshop.service.api.ItemService;
import com.demoshop.demoshop.service.api.OrderService;
import com.demoshop.demoshop.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import com.demoshop.demoshop.web.viewModel.OrderViewModel;

import java.util.stream.Collectors;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private Cart cart;

    @GetMapping("/orders/current")
    public String orderForm(Model model) {
        model.addAttribute("productOrder", new OrderViewModel());
        return "orderForm";
    }

    @PostMapping("/orders")
    public String processOrder(@Valid @ModelAttribute("productOrder") OrderViewModel orderViewModel,
                               Authentication authentication, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        Order order = createOrder(orderViewModel);
        orderService.submit(order);
        log.info("Order submitted: " + order);

        String username = authentication.getName();
        User user = userService.findUserByUsername(username);
        Role customerRole = userService.findRoleByName("ROLE_CUSTOMER");
        user.removeRole(customerRole);
        userService.updateUser(user);
        authenticationService.updateAuthoritiesInSecurityContext(authentication);

        cart.emptyCart();
        return "redirect:/";
    }

    @GetMapping("/buyItems")
    public String assignCustomerRoleToUser(Authentication authentication) {
        if (authentication == null) return "redirect:/login";
        String username = authentication.getName();
        User user = userService.findUserByUsername(username);
        Role customerRole = userService.findRoleByName("ROLE_CUSTOMER");
        user.addRole(customerRole);
        userService.updateUser(user);
        authenticationService.updateAuthoritiesInSecurityContext(authentication);
        return "redirect:/orders/current";
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
                .map(ItemDto::getId)
                .map(itemService::getItemById)
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
