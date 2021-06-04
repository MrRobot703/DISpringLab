package com.demoshop.demoshop.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "simple_pet")
public class SimplePet {
    @Id
    @Column(name = "simple_pet_id")
    @SequenceGenerator(
            name = "simple_pet_id_seq_Gen",
            sequenceName = "simple_pet_id_seq",
            allocationSize = 50,
            initialValue = 10000
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simple_pet_id_seq_Gen")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "simplePet", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<SimpleToy> toys;
}
