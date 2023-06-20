package com.lab.service.impl;

import com.lab.data.domain.Department;
import com.lab.data.domain.Employee;
import com.lab.data.repository.api.SimpleDepartmentRepository;
import com.lab.data.repository.api.SimpleEmployeeRepository;
import com.lab.service.api.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private SimpleEmployeeRepository employeeRepository;

    @Autowired
    private SimpleDepartmentRepository departmentRepository;

    @Override
    public boolean addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean removeEmployee(Employee employee) {
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        return employeeRepository.findById(employee.getId()).orElse(null);
    }

    @Override
    public boolean addDepartment(Department department) {
        departmentRepository.save(department);
        return true;
    }

    @Override
    public boolean removeDepartment(Department department) {
        departmentRepository.delete(department);
        return true;
    }

    @Override
    public Department findDepartment(Department department) {
        return departmentRepository.findById(department.getId()).orElse(null);
    }
}
