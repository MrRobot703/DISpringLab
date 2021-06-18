package com.demoshop.demoshop.repositories;

import com.demoshop.demoshop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Nullable
    User findByUsername(String username);

    @Nullable
    List<User> findByEmail(String email);

    @Nullable
    Long deleteByUsername(String username);
}
