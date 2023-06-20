package com.lab.service.api;

import com.lab.data.domain.Department;
import com.lab.data.domain.Employee;

public interface CompanyService {
    boolean addEmployee(Employee employee);
    boolean removeEmployee(Employee employee);
    Employee findEmployee(Employee employee);
    boolean addDepartment(Department department);
    boolean removeDepartment(Department department);
    Department findDepartment(Department department);
}
