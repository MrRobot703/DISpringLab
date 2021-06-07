package com.demoshop.demoshop.repositories;


import com.demoshop.demoshop.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
