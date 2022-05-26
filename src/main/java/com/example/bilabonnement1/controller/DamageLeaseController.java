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
    LeaseService leaseService;
    CarRepository carRepository;
    CarService carService = new CarService();
    DamageRepository damageRepository = new DamageRepository();
    EmployeeRepository employeeRepository = new EmployeeRepository();
    EmployeeService employeeService = new EmployeeService();
    DamageService damageService = new DamageService();


    @GetMapping("/RegistrerSkade")
    public String Registrer() {
        return "DamageRegistration";
    }

    @PostMapping("/RegistrerSkade")
    public String RegistrerSkade(@RequestParam("carID") int carID,
                                 @RequestParam("carPart") String carPart,
                                 @RequestParam("carDamage") String carDamage,
                                 @RequestParam("price") int price) throws SQLException {
        if (carService.carFound(carID)) {
            DamageReport dr = new DamageReport(carID,carPart, carDamage,price);
            damageRepository.createDamageReport(dr);
            return "redirect:/allDamageReports";
        }
        else {
            return "FejlLogin";
        }

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
        if (carService.carFound(carID)) {
            Lease l = new Lease(clientID, carID, VIN, price);
            leaseRepository.createLeje(l);

            return "redirect:/viewAllLeaseRegistration";
        } else {
            return "FejlLogin";

        }
    }

    @GetMapping("/SletLease")
    public String slet() {
        return "LeaseDelete";
    }

    @PostMapping("/SletLease")
    public String sletLease(@RequestParam("leaseID") int leaseID) {
        leaseRepository.deleteLease(leaseID);
        return "redirect:/viewAllLeaseRegistration";
    }

    @GetMapping("/FindReport")
    public String findReport() {
        return "FindDamage";
    }

    @PostMapping("/FindReport")
    public String find(Model model,
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


}

