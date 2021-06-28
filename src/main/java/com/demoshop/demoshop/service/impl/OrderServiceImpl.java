package com.demoshop.demoshop.service.impl;

import com.demoshop.demoshop.model.Order;
import com.demoshop.demoshop.repositories.OrderRepository;
import com.demoshop.demoshop.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void submit(Order order) {
        order.placeAt();
        orderRepository.save(order);
    }

    @Override
    public void submit(List<Order> orders) {
        orders.forEach(Order::placeAt);
        orderRepository.saveAll(orders);
    }
}
