package com.lab.data.repository.api;

import com.lab.data.domain.Employee;

import java.util.Collection;

public interface EmployeeRepository extends CrudRepository<Employee>{

    Collection<Employee> getEmployees();
}
