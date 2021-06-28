package com.demoshop.demoshop.service.api;

import com.demoshop.demoshop.model.Order;

import java.util.List;

public interface OrderService {

    void submit(Order order);

    void submit(List<Order> orders);
}
