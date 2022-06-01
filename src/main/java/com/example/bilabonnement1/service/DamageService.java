package com.example.bilabonnement1.service;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.DamageRepository;

import java.util.ArrayList;

//Lavet af Naomi

public class DamageService {
    DamageRepository damageRepository = new DamageRepository();

    public ArrayList<DamageReport> getAllReports(){
        ArrayList<DamageReport> reports = damageRepository.getAllReports();

        return reports;

    }

}
