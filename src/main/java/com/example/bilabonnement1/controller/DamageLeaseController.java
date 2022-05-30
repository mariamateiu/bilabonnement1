package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.CarRepository;
import com.example.bilabonnement1.repository.DamageRepository;
import com.example.bilabonnement1.repository.EmployeeRepository;
import com.example.bilabonnement1.repository.LeaseRepository;
import com.example.bilabonnement1.service.CarService;
import com.example.bilabonnement1.service.DamageService;
import com.example.bilabonnement1.service.EmployeeService;
import com.example.bilabonnement1.service.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class DamageLeaseController {
    LeaseRepository leaseRepository = new LeaseRepository();
    CarService carService = new CarService();
    DamageRepository damageRepository = new DamageRepository();





    @GetMapping("/RegistrerLease")
    public String registrerLease() {
        return "LeaseRegistration";
    }

    @PostMapping("/RegistrerLease")
    public String registrerLease(@RequestParam("Client ID") int clientID,
                           @RequestParam("Car ID") int carID,
                           @RequestParam("VIN") int VIN,
                           @RequestParam("Price") int price) throws SQLException {
        if (carService.carFound(carID)) {              // Tjekker om det indtastede carID matcher med en bil i databasen
            Lease l = new Lease(clientID, carID, VIN, price);
            leaseRepository.createLeje(l);

            return "redirect:/viewAllLeaseRegistration";
        } else {
            return "FejlLogin";

        }
    }

    @GetMapping("/FindLease")
    public String findLease() {
        return "FindLease";
    }

    @PostMapping("/FindLease")
    public String findLease(Model model,
                            @RequestParam("leaseID") int leaseID) {
        Lease lease = leaseRepository.findLease(leaseID);
        model.addAttribute("lease", lease);

        return "FindLeaseTaable";
    }

    @GetMapping("/SletLease")
    public String sletLease() {
        return "LeaseDelete";
    }

    @PostMapping("/SletLease")
    public String sletLease(@RequestParam("leaseID") int leaseID) {
        leaseRepository.deleteLease(leaseID);
        return "redirect:/viewAllLeaseRegistration";
    }
    @GetMapping("/RegistrerSkade")
    public String registrerSkade() {
        return "DamageRegistration";
    }

    @PostMapping("/RegistrerSkade")
    public String registrerSkade(@RequestParam("clientID") int clientID,
                                 @RequestParam("carID") int carID,
                                 @RequestParam("carPart") String carPart,
                                 @RequestParam("carDamage") String carDamage,
                                 @RequestParam("price") int price) throws SQLException {
        if (carService.carFound(carID)) {              // Tjekker om det indtastede carID matcher med en bil i databasen
            DamageReport dr = new DamageReport(clientID,carID,carPart, carDamage,price);
            damageRepository.createDamageReport(dr);
            return "redirect:/allDamageReports";
        }
        else {
            return "FejlLogin";
        }

    }

    @GetMapping("/FindReport")
    public String findReport() {
        return "FindDamage";
    }

    @PostMapping("/FindReport")
    public String findReport(Model model,
                       @RequestParam("reportID") int damageReportID) {
        DamageReport damageReport = damageRepository.findReport(damageReportID);
        model.addAttribute("report", damageReport);

        return "FindDamageTaable";
    }
    @GetMapping("/SletDamage")
    public String sletDamage() {
        return "DeleteDamage";
    }

    @PostMapping("/SletDamage")
    public String sletDamage(@RequestParam("reportID") int damageReportID) {
        damageRepository.deleteReport(damageReportID);
        return "redirect:/allDamageReports";
    }



}

