package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.repository.CarRepository;
import com.example.bilabonnement1.repository.DamageRepository;
import com.example.bilabonnement1.repository.EmployeeRepository;
import com.example.bilabonnement1.repository.LeaseRepository;
import com.example.bilabonnement1.service.CarService;
import com.example.bilabonnement1.service.EmployeeService;
import com.example.bilabonnement1.service.LeaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
    ArrayList<Employee> user = new ArrayList<>();

    LeaseRepository leaseRepository;
    LeaseService leaseService;
    CarRepository carRepository;
    CarService carService;
    DamageRepository damageRepository;
    EmployeeRepository employeeRepository = new EmployeeRepository();
    EmployeeService employeeService = new EmployeeService();


    @GetMapping("/OpretMedarbejder")
    public String opretMedarbejer() {
        return "OpretBruger";
    }


    @PostMapping("/OpretMedarbejder")
    public String opret(@RequestParam("fullname") String fullName,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type) {

        Employee em = new Employee();
        if (type.equalsIgnoreCase("skade") || type.equalsIgnoreCase("data") || type.equalsIgnoreCase("forretning")) {
            em.setFullName(fullName);
            em.setPassword(password);
            em.setType(type);
            employeeRepository.createUser(em);
            return "/Login";
        } else {
            return "/FejlOprettelse";
        }
    }

    @GetMapping("/Login")
    public String login() {
        return "Login";
    }

    @PostMapping("/Login")
    public String loginTjek(@RequestParam("navn") String name,
                            @RequestParam("password") String password) throws SQLException {
        Employee employee = employeeRepository.findUser(name);
        user.add(0, employee);
        if (employeeService.loginSucces(employee, password)) {
            if (employee.getType().equalsIgnoreCase("forretning")) {
                return "redirect:/MenuBusiness";
            }
            if (employee.getType().equalsIgnoreCase("data")) {
                return "redirect:/MenuData";
            }
            if (employee.getType().equalsIgnoreCase("skade")) {
                return "redirect:/MenuDamage";
            }
            if (!employeeService.loginSucces(employee, password)) {
                return "FejlLogin";
            }

        }
        return "FejlLogin";
    }

    @GetMapping("/MenuData")
    public String menuData(Model model) {
        ArrayList<Employee> users = user;
        Employee em = users.get(0);
        System.out.println(users);
        model.addAttribute("fullName", em.getFullName());
        return "MenuData";
    }

    @GetMapping("/MenuDamage")
    public String menuDame(Model model) {
        ArrayList<Employee> users = user;
        Employee em = users.get(0);
        System.out.println(users);
        model.addAttribute("fullName", em.getFullName());
        return "MenuDamage";
    }

    @GetMapping("/MenuBusiness")
    public String menuBusiness(Model model) {
        ArrayList<Employee> users = user;
        Employee em = users.get(0);
        System.out.println(users);
        model.addAttribute("fullName", em.getFullName());
        return "MenuBusiness";
    }

    @PostMapping("/Tilbage")
    public String tilbage() {
        ArrayList<Employee> users = user;
        Employee em = users.get(0);
        if (em.getType().equalsIgnoreCase("forretning")) {
            return "redirect:/MenuBusiness";
        }
        if (em.getType().equalsIgnoreCase("data")) {
            return "redirect:/MenuData";
        }
        if (em.getType().equalsIgnoreCase("skade")) {
            return "redirect:/MenuDamage";
        }
        return "";

    }
}
