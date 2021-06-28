package com.demoshop.demoshop.repositories;

import com.demoshop.demoshop.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    @Nullable
    Privilege findByName(String name);
}
