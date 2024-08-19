package com.codemyth.service;

import com.codemyth.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private List<Employee> empList = new ArrayList<>();

    public EmployeeService() {
        empList.add(new Employee(UUID.randomUUID().toString(), "Shahjahan", "shahjahan12@gmail.com"));
        empList.add(new Employee(UUID.randomUUID().toString(), "Feroz Ahmed", "feroz12@gmail.com"));
        empList.add(new Employee(UUID.randomUUID().toString(), "Raheel Ahmed", "raheel12@gmail.com"));
        empList.add(new Employee(UUID.randomUUID().toString(), "hamza", "hamza12@gmail.com"));
    }

    public List<Employee> getEmployeesList() {
        return empList;
    }
}
