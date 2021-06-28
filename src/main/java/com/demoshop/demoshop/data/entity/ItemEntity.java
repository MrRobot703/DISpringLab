package com.demoshop.demoshop.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Table(name = "item")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
        @Id
        @Column(name = "item_id")
        @SequenceGenerator(
                name = "item_id_seq_Gen",
                sequenceName = "item_id_seq",
                allocationSize = 50,
                initialValue = 1000
        )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq_Gen")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "price")
        private double price;

        @Column(name = "description")
        private String description;

}


