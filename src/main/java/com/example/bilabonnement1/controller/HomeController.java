package com.example.bilabonnement1.controller;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.repository.DamageRepository;
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

}
