package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.repository.EmployeeRepository;
import com.example.bilabonnement1.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class UserController {
    ArrayList<Employee> employees = new ArrayList<>();

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
        employees.add(0, employee);    // Bruges til at printe navn på medarbejeren på menu-siderne
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
        Employee em = employees.get(0);      // Finder den bruger, der er logget ind på log-in siden
        model.addAttribute("fullName", em.getFullName());
        return "MenuData";
    }

    @GetMapping("/MenuDamage")
    public String menuDame(Model model) {
        Employee em = employees.get(0);      // Finder den bruger, der er logget ind på log-in siden
        model.addAttribute("fullName", em.getFullName());
        return "MenuDamage";
    }

    @GetMapping("/MenuBusiness")
    public String menuBusiness(Model model) {
        Employee em = employees.get(0);      // Finder den bruger, der er logget ind på log-in siden
        model.addAttribute("fullName", em.getFullName());
        return "MenuBusiness";
    }

    @PostMapping("/Tilbage")
    public String tilbage() {
        Employee em = employees.get(0);      // Finder den bruger, der er logget ind på log-in siden
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
