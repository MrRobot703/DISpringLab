package com.demoshop.demoshop.repositories;

import com.demoshop.demoshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
