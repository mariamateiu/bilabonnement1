package com.example.bilabonnement1.service;

import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.ArrayList;

//Lavet af Nanna

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

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
