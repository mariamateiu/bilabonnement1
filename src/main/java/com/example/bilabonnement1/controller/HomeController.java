package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.DamageRepository;
import com.example.bilabonnement1.repository.LejeRepository;
import com.example.bilabonnement1.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bilabonnement1.repository.*;
import com.example.bilabonnement1.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


@Controller
public class HomeController {


    LejeRepository lejeRepository;
    LeaseService leaseService;


    public HomeController(LejeRepository lejeRepository, LeaseService leaseService){
        this.lejeRepository = lejeRepository;
        this.leaseService = leaseService;
    }


    DamageRepository dm = new DamageRepository();
    EmployeeRepository er = new EmployeeRepository();
    EmployeeService es = new EmployeeService();


    @GetMapping("/hej")
    public String test() {
        return "DamageRegistration";
    }

    @GetMapping("/RegistrerSkade")
    public String Registrer() {
        return "DamageRegistration";
    }

    @PostMapping("/RegistrerSkade")
    public String RegistrerSkade(@RequestParam("carID") int carID,
                                 @RequestParam("carPart") String carPart,
                                 @RequestParam("carDamage") String carDamage,
                                 @RequestParam("price") String price) throws SQLException {
        DamageReport dr = new DamageReport();
        dr.setCarID(carID);
        dr.setCarPart(carPart);
        dr.setDamageDescription(carDamage);
        dr.setDamagePrice(price);

        dm.createDamageReport(dr);

        return "redirect:/";
    }


    @GetMapping("/RegistrerLease")
    public String lease() {
        return "LeaseRegistration";
    }

    @PostMapping("/RegistrerLease")
    public String regLease(@RequestParam("Client ID") int clientID,
                           @RequestParam("Car ID") int carID,
                           @RequestParam("VIN") int VIN,
                           @RequestParam("Price") int price) throws SQLException {
        Lease l = new Lease(clientID, carID, VIN, price);
        LejeRepository lr = new LejeRepository();
        lr.createLeje(l);

        return "redirect:/";
    }

    @GetMapping("/OpretMedarbejder")
    public String opretMedarbejer() {
        return "OpretBruger";
    }

    @PostMapping("/OpretMedarbejder")
    public String opret(@RequestParam("fullname") String fullName,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type) {

        Employee em = new Employee();
        em.setFullName(fullName);
        em.setPassword(password);
        em.setType(type);

        er.createUser(em);


        return "/Login";

    }

    @GetMapping("/Login")
    public String login() {
        return "Login";
    }

    @PostMapping("/Login")
    public String loginTjek(@RequestParam("navn") String name,
                            @RequestParam("password") String password) throws SQLException {
        Employee employee = er.findUser(name);
        if (es.loginSucces(employee, password)) {
            if (employee.getType().equalsIgnoreCase("forretning")) {
                return "MenuBusiness";
            }
            if (employee.getType().equalsIgnoreCase("data")) {
                return "MenuData";
            }
            if (employee.getType().equalsIgnoreCase("skade")) {
                return "MenuDamage";
            } else {

                    return "Brugeren findes ikke";
                }


            }
            return "";
        }



                @GetMapping("/viewAllLeaseRegistration")

                public String viewAllLeaseRegistration (Model model ){

                    ArrayList<Lease> leases = lejeRepository.getAllLeases();


                    model.addAttribute("leases", leases);
                    model.addAttribute("totalPrice",leaseService.getTotalPrice(leases));
                    // model.addAttribute("testString", "Please virk for helvede");


                    return "/LeaseTable";

                }


            }




