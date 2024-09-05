package com.saransh.employeemanager.service;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saransh.employeemanager.exception.UserNotFoundException;
import com.saransh.employeemanager.model.Employee;
import com.saransh.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updaEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public Employee findEmployeeById(Long id)
    {
        return employeeRepository.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by Id"+id+" was not found."));
    }
    public void deleteEmployee(Long id)
    {
        employeeRepository.deleteEmployeeById(id);
    }
}
