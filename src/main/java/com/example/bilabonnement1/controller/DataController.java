package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.Car;
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

import java.util.ArrayList;

@Controller
public class DataController {
    LeaseService leaseService = new LeaseService();
    CarService carService = new CarService();
    DamageService damageService = new DamageService();

    //Primært lavet af Naomi

    @GetMapping("/viewAllLeaseRegistration")
    public String viewAllLeaseRegistration(Model model) {

        ArrayList<Lease> leases = leaseService.getAllLeases();

        //tilføjer leases listen til vores model objekt, så vi kan bruge den i vores html
        model.addAttribute("leases", leases);
        model.addAttribute("totalPrice", leaseService.getTotalPrice(leases));
        model.addAttribute("totalAmount", leases.size());


        return "LeaseTable";

    }


    @GetMapping("/viewAllLeasedCar")

    public String viewAllLeasedCar(Model model) {

        ArrayList<Car> allLeasedCars = carService.allLeasedCar();

        System.out.println(allLeasedCars);
        model.addAttribute("cars", allLeasedCars);


        return "CarTable";

    }


    @GetMapping("/allLeasedCarAvailable")

    public String allLeasedCarAvailable(Model model) {

        ArrayList<Car> cars = carService.allLeasedCarAvailable();

        System.out.println(cars);
        model.addAttribute("cars", cars);
        return "CarAvailable";

    }

    @GetMapping("/allLeasedCarNotAvailable")

    public String allLeasedCarNotAvailable(Model model) {

        ArrayList<Car> cars = carService.allLeasedCarNotAvailable();

        System.out.println(cars);
        model.addAttribute("cars", cars);


        return "CarNotAvailable";

    }

    @GetMapping("/allDamageReports")
    public String damageTable(Model model) {
        ArrayList<DamageReport> reports = damageService.getAllReports();

        model.addAttribute("reports", reports);

        return "DamageTable";
    }
}


