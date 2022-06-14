package com.example.bilabonnement1.service;

import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.EmployeeRepository;
import com.example.bilabonnement1.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

//Lavet af Nanna

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public void createUser(Employee user){
        employeeRepository.createUser(user);
    }

    public Employee findUser(String fullName){
        return employeeRepository.findUser(fullName);
    }


    public Boolean loginSucces(Employee employee, String password) throws SQLException {
        Boolean succes = false;
        employee = employeeRepository.findUser(employee.getFullName());
        if (employee != null) {
            if (employee.getPassword().equalsIgnoreCase(password))
                succes = true;
        }
        return succes;
    }


}
