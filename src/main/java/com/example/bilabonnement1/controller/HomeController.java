package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.Car;
import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.DamageRepository;
import com.example.bilabonnement1.repository.LeaseRepository;
import com.example.bilabonnement1.service.CarService;
import com.example.bilabonnement1.service.LeaseService;
import com.example.bilabonnement1.repository.*;
import com.example.bilabonnement1.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;


@Controller
public class HomeController {
    ArrayList<Employee> user = new ArrayList<>();
    LeaseRepository leaseRepository;
    LeaseService leaseService;
    CarRepository carRepository;
    CarService carService;
    DamageRepository damageRepository;
    EmployeeRepository employeeRepository = new EmployeeRepository();
    EmployeeService employeeService = new EmployeeService();


    public HomeController(LeaseRepository leaseRepository, LeaseService leaseService, CarRepository carRepository, CarService carService) {
        this.leaseRepository = leaseRepository;
        this.leaseService = leaseService;
        this.carRepository = carRepository;
        this.carService = carService;
    }


    @GetMapping("/")
    public String index() {
        return "Login";
    }





}


