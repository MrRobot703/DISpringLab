package com.lab.data.repository.impl;

import com.lab.data.domain.Department;
import com.lab.data.repository.api.DepartmentRepository;

import java.util.Collection;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    @Override
    public boolean create(Department department) {
        return false;
    }

    @Override
    public Department read(long id) {
        return null;
    }

    @Override
    public boolean update(Department department) {
        return false;
    }

    @Override
    public boolean delete(Department department) {
        return false;
    }

    @Override
    public Collection<Department> getDepartments() {
        return null;
    }
}
