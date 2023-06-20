package com.lab.data.repository.api;

import com.lab.data.domain.Department;
import org.springframework.data.repository.CrudRepository;

public interface SimpleDepartmentRepository extends CrudRepository<Department, Long> {
}
