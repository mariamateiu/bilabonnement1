package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.repository.EmployeeRepository;
import com.example.bilabonnement1.service.CarService;
import com.example.bilabonnement1.service.DamageService;
import com.example.bilabonnement1.service.EmployeeService;
import com.example.bilabonnement1.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class UserController {
    CarService carService;
    DamageService damageService;
    LeaseService leaseService;
    EmployeeService employeeService;
    Employee employee;

    @Autowired
    public UserController(CarService carService, DamageService damageService, LeaseService leaseService, EmployeeService employeeService){
        this.carService = carService;
        this.damageService = damageService;
        this.leaseService = leaseService;
        this.employeeService = employeeService;
    }
    //Primært lavet af Nanna

    @GetMapping("/")
    public String index(){
        return "Login";
    }

    @GetMapping("/CreateUser")
    public String createEmployeeUser() {
        return "OpretBruger";
    }


    @PostMapping("/CreateUser")
    public String createEmployeeUser(@RequestParam("fullname") String fullName,
                                     @RequestParam("password") String password,
                                     @RequestParam("type") String type) {
        Employee em = new Employee();
        if (type.equalsIgnoreCase("damage") || type.equalsIgnoreCase("data") || type.equalsIgnoreCase("business")) {
            em.setFullName(fullName);
            em.setPassword(password);
            em.setType(type);
            employeeService.createUser(em);
            return "redirect:Login";
        } else {
            return "FejlOprettelse";
        }

    }

    @GetMapping("/Login")
    public String login() {
        return "Login";
    }

    @PostMapping("/Login")
    public String login(@RequestParam("navn") String name,
                        @RequestParam("password") String password) throws SQLException {
        Employee employee = employeeService.findUser(name);
        if (employeeService.loginSucces(employee, password)) {
            if (employee.getType().equalsIgnoreCase("business")) {
                return "redirect:MenuBusiness";
            }
            if (employee.getType().equalsIgnoreCase("data")) {
                return "redirect:MenuData";
            }
            if (employee.getType().equalsIgnoreCase("damage")) {
                return "redirect:MenuDamage";
            }
        }
        return "FejlLogin";
    }

    @GetMapping("/MenuData")
    public String menuData(Model model) {
              // Finder den bruger, der er logget ind på log-in siden
            model.addAttribute("fullName", employee.getFullName());
            return "MenuData";
        }


    @GetMapping("/MenuDamage")
    public String menuDamage(Model model) {
        model.addAttribute("fullName", employee.getFullName());
        return "MenuDamage";
    }

    @GetMapping("/MenuBusiness")
    public String menuBusiness(Model model) {
        model.addAttribute("fullName", employee.getFullName());
        return "MenuBusiness";
    }

    @PostMapping("/Back")
    public String goBack() {
        if (employee.getType().equalsIgnoreCase("business")) {
            return "redirect:MenuBusiness";
        }
        if (employee.getType().equalsIgnoreCase("data")) {
            return "redirect:MenuData";
        }
        if (employee.getType().equalsIgnoreCase("damage")) {
            return "redirect:MenuDamage";
        }
        return "";

    }

    @PostMapping("/Logout")
    public String logOut(){
        employee = null;
        return "redirect:Login";

    }

}
