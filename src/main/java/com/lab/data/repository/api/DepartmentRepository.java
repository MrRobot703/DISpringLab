package com.lab.data.repository.api;

import com.lab.data.domain.Department;

import java.util.Collection;

public interface DepartmentRepository extends CrudRepository<Department> {
    Collection<Department> getDepartments();
}
