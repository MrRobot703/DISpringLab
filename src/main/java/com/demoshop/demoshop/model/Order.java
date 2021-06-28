package com.demoshop.demoshop.model;

import com.demoshop.demoshop.data.entity.ItemEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String street;

    private String city;

    private String ccNumber;

    private String ccExpiration;

    private String ccCVV;

    private Date placedAt;

    @ManyToMany(targetEntity = ItemEntity.class)
    private List<ItemEntity> items;

    public void addProduct(ItemEntity product) {
        this.items.add(product);
    }

    @PrePersist
    public void placeAt() {
        this.placedAt = new Date();
    }
}
