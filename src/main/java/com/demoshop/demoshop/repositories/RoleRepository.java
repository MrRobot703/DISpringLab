package com.demoshop.demoshop.repositories;

import com.demoshop.demoshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Nullable
    Role findByName(String name);
}
