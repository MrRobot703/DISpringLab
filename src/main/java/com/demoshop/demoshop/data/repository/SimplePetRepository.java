package com.demoshop.demoshop.data.repository;

import com.demoshop.demoshop.data.entity.SimplePet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimplePetRepository extends JpaRepository<SimplePet, Long> {
}
