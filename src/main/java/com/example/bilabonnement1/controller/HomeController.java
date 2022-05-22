package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;


@Controller
public class HomeController {
    DamageRepository dm = new DamageRepository();


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
    public String opretMedarbejer(){
        return "OpretBruger";
    }

    @PostMapping("/OpretMedarbejder")
    public String opret(@RequestParam("fullname") String fullName,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type) throws SQLException {
        Employee em = new Employee();
        em.setFullName(fullName);
        em.setPassword(password);
        if (type.equalsIgnoreCase("forretning")){
            BusinessEmployeeRepository be = new BusinessEmployeeRepository();
            be.createBE(em);
        } if(type.equalsIgnoreCase("data")){
            DataEmployeeRepository de = new DataEmployeeRepository();
            de.createDTE(em);
        } if(type.equalsIgnoreCase("skade")){
            DamageEmployeeRepository dm = new DamageEmployeeRepository();
            dm.createDME(em);
        }else{
            return "fejl";
        }
        return "redirect:/";

    }


}
