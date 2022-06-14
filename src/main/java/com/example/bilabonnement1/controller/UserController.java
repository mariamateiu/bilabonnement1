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
    ArrayList<Employee> employees = new ArrayList<>();
    CarService carService;
    DamageService damageService;
    LeaseService leaseService;
    EmployeeService employeeService;

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
        employees.add(0, employee);    // Bruges til at printe navn på medarbejeren på menu-siderne
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
    public String menuDamage(Model model) {
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

    @PostMapping("/Back")
    public String goBack() {
        Employee em = employees.get(0);      // Finder den bruger, der er logget ind på log-in siden
        if (em.getType().equalsIgnoreCase("business")) {
            return "redirect:MenuBusiness";
        }
        if (em.getType().equalsIgnoreCase("data")) {
            return "redirect:MenuData";
        }
        if (em.getType().equalsIgnoreCase("damage")) {
            return "redirect:MenuDamage";
        }
        return "";

    }

    @PostMapping("/Logout")
    public String logOut(){
        employees.remove(0);      //Sletter den bruger der er logget ind, fra arraylisten
        return "redirect:Login";

    }

}
