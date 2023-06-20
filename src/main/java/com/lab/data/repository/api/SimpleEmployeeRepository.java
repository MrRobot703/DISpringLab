package com.lab.data.repository.api;

import com.lab.data.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

public interface SimpleEmployeeRepository extends CrudRepository<Employee, Long> {
    @Nullable
    Iterable<Employee> findByLastName(String lastName);
}
