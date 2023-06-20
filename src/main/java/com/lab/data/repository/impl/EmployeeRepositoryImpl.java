package com.lab.data.repository.impl;

import com.lab.data.domain.Employee;
import com.lab.data.repository.api.EmployeeRepository;

import java.util.Collection;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public boolean create(Employee employee) {
        return false;
    }

    @Override
    public Employee read(long id) {
        return null;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    public Collection<Employee> getEmployees() {
        return null;
    }
}
