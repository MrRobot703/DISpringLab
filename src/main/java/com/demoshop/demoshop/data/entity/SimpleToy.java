package com.demoshop.demoshop.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "simple_toy")
public class SimpleToy {
    @Id
    @Column(name = "simple_toy_id")
    @SequenceGenerator(
            name = "simple_toy_id_seq_Gen",
            sequenceName = "simple_toy_id_seq",
            allocationSize = 50,
            initialValue = 10000
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simple_toy_id_seq_Gen")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "simple_pet_id")
    private SimplePet simplePet;
}
