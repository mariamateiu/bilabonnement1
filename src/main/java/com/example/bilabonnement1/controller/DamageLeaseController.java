package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.CarRepository;
import com.example.bilabonnement1.repository.DamageRepository;
import com.example.bilabonnement1.repository.EmployeeRepository;
import com.example.bilabonnement1.repository.LeaseRepository;
import com.example.bilabonnement1.service.CarService;
import com.example.bilabonnement1.service.EmployeeService;
import com.example.bilabonnement1.service.LeaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

public class DamageLeaseController {
    LeaseRepository leaseRepository;
    LeaseService leaseService;
    CarRepository carRepository;
    CarService carService;
    DamageRepository damageRepository;
    EmployeeRepository employeeRepository = new EmployeeRepository();
    EmployeeService employeeService = new EmployeeService();


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

        damageRepository.createDamageReport(dr);

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
        leaseRepository.createLeje(l);

        return "redirect:/viewAllLeaseRegistration";
    }

    @GetMapping("/SletLease")
    public String slet() {
        return "LeaseDele";
    }

    @PostMapping("/SletLease")
    public String sletLease(@RequestParam("leaseID") int leaseID) {
        leaseRepository.deleteLease(leaseID);
        return "redirect:/viewAllLeaseRegistration";
    }
}
