package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.Car;
import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.DamageRepository;
import com.example.bilabonnement1.repository.LeaseRepository;
import com.example.bilabonnement1.service.CarService;
import com.example.bilabonnement1.service.LeaseService;
import com.example.bilabonnement1.repository.*;
import com.example.bilabonnement1.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;


@Controller
public class HomeController {


    CarService carService;
    LeaseService leaseService;
    LeaseRepository leaseRepository;
    CarRepository carRepository;


    public HomeController(LeaseRepository leaseRepository, LeaseService leaseService, CarRepository carRepository, CarService carService){
        this.leaseRepository = leaseRepository;
        this.leaseService = leaseService;
        this.carRepository = carRepository;
        this.carService=carService;
    }


    DamageRepository dm = new DamageRepository();
    EmployeeRepository er = new EmployeeRepository();
    EmployeeService es = new EmployeeService();

    @GetMapping("/")
    public String index() {
        return "Login";
    }

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
        LeaseRepository lr = new LeaseRepository();
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

                    ArrayList<Lease> leases = leaseService.getAllLeases();

                    //tilføjer leases listen til vores model objekt, så vi kan bruge den i vores html
                    model.addAttribute("leases", leases);
                    model.addAttribute("totalPrice",leaseService.getTotalPrice(leases));
                    model.addAttribute("totalAmount",leases.size());


                    // model.addAttribute("testString", "Please virk for helvede");


                    return "/LeaseTable";

                }


        @GetMapping("/viewAllLeasedCar")

            public String viewAllLeasedCar (Model model ){

            ArrayList<Car> allLeasedCars = carService.allLeasedCar();

            System.out.println(allLeasedCars);
            model.addAttribute("cars", allLeasedCars);
            //model.addAttribute("totalPrice",leaseService.getTotalPrice(leases));
            // model.addAttribute("testString", "Please virk for helvede");


            return "/CarTable";

        }


    @GetMapping("/allLeasedCarAvailable")

    public String allLeasedCarAvailable (Model model ){

        ArrayList<Car> cars = carService.allLeasedCarAvailable();

        System.out.println(cars);
        model.addAttribute("cars", cars);
        //model.addAttribute("totalPrice",leaseService.getTotalPrice(leases));
        // model.addAttribute("testString", "Please virk for helvede");


        return "/CarAvailable";

    }

    @GetMapping("/allLeasedCarNotAvailable")

    public String allLeasedCarNotAvailable (Model model ){

        ArrayList<Car> cars = carService.allLeasedCarNotAvailable();

        System.out.println(cars);
        model.addAttribute("cars", cars);
        //model.addAttribute("totalPrice",leaseService.getTotalPrice(leases));
        // model.addAttribute("testString", "Please virk for helvede");


        return "/CarNotAvailable";

    }




}




