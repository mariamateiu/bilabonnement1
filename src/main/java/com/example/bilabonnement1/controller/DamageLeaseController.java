package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.Car;
import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.CarRepository;
import com.example.bilabonnement1.repository.DamageRepository;
import com.example.bilabonnement1.repository.LeaseRepository;
import com.example.bilabonnement1.service.CarService;
import com.example.bilabonnement1.service.DamageService;
import com.example.bilabonnement1.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

//Primært lavet af Nanna

@Controller
public class DamageLeaseController {
    CarService carService;
    DamageService damageService;
    LeaseService leaseService;

    @Autowired
    public DamageLeaseController(CarService carService, DamageService damageService, LeaseService leaseService){
    this.carService = carService;
    this.damageService = damageService;
    this.leaseService = leaseService;
    }


    @GetMapping("/CreateLease")
    public String createLease() {
        return "LeaseRegistration";
    }

    @PostMapping("/CreateLease")
    public String createLease(@RequestParam("clientID") int clientID,
                              @RequestParam("carID") int carID,
                              @RequestParam("price") int price) throws SQLException {
        if (carService.carFound(carID)) {              // Tjekker om det indtastede carID matcher med en bil i databasen
            Lease l = new Lease(clientID, carID, price);
            if (carService.findCar(carID).getAvailable() == 1) {
                return "Error";
            }
            if (carService.findCar(carID).getAvailable() == 0) {
                carService.carLeased(carID, 1);   //Sætter bilen til, ikke at være til rådighed
                leaseService.createLease(l);
                return "redirect:viewAllLeaseRegistration";
            }
        }
        return "Error";

    }


    @GetMapping("/FindLease")
    public String findLease() {
        return "FindLease";
    }

    @PostMapping("/FindLease")
    public String findLease(Model model,
                            @RequestParam("leaseID") int leaseID) {
        Lease lease = leaseService.findLease(leaseID);
        model.addAttribute("lease", lease);
        System.out.println(lease);
        return "FindLeaseTaable";
    }

    @GetMapping("/DeleteLease")
    public String deleteLease() {
        return "LeaseDelete";
    }

    @PostMapping("/DeleteLeaseContract")
    public String deleteLease(@RequestParam("leaseID") int leaseID) {
        Lease lease = leaseService.findLease(leaseID);

        carService.carLeased(lease.getCarID(), 0);    //Sætter bilen til at være ledig igen, efter leasen er slettet
        leaseService.deleteLease(leaseID);
        System.out.println(leaseID);
        return "redirect:viewAllLeaseRegistration";
    }

    @GetMapping("/CreateDamageReport")
    public String createDamageReport() {
        return "DamageRegistration";
    }

    @PostMapping("/CreateDamageReport")
    public String createDamageReport(@RequestParam("clientID") int clientID,
                                     @RequestParam("carID") int carID,
                                     @RequestParam("carPart") String carPart,
                                     @RequestParam("carDamage") String carDamage,
                                     @RequestParam("price") int price) throws SQLException {
        if (carService.carFound(carID)) {              // Tjekker om det indtastede carID matcher med en bil i databasen
            DamageReport dr = new DamageReport(clientID, carID, carPart, carDamage, price);
            damageService.createDamageReport(dr);
            return "redirect:allDamageReports";
        } else {
            return "Error";
        }

    }

    @GetMapping("/FindReport")
    public String findReport() {
        return "FindDamage";
    }

    @PostMapping("/FindReport")
    public String findReport(Model model,
                             @RequestParam("reportID") int damageReportID) {
        DamageReport damageReport = damageService.findReport(damageReportID);
        model.addAttribute("report", damageReport);

        System.out.println(damageReport);
        return "FindDamageTaable";
    }

    @GetMapping("/DeleteDamage")
    public String deleteDamageReport() {
        return "DeleteDamage";
    }

    @PostMapping("/DeleteDamage")
    public String deleteDamageReport(@RequestParam("reportID") int damageReportID) {
        damageService.deleteReport(damageReportID);
        System.out.println(damageReportID);
        return "redirect:allDamageReports";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }


}

