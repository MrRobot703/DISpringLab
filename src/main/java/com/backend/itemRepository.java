package com.backend;

import com.backend.entity.itemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepository extends JpaRepository<itemEntity, Long> {

}
