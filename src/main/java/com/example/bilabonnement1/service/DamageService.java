package com.example.bilabonnement1.service;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.DamageRepository;
import com.example.bilabonnement1.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

//Lavet af Naomi
@Service

public class DamageService {
    DamageRepository damageRepository;
    @Autowired
    public DamageService(DamageRepository damageRepository){
        this.damageRepository = damageRepository;
    }


    public void createDamageReport(DamageReport damageReport) throws SQLException {
        damageRepository.createDamageReport(damageReport);
    }

    public ArrayList<DamageReport> getAllReports(){
        ArrayList<DamageReport> reports = damageRepository.getAllReports();

        return reports;

    }

    public DamageReport findReport(int damageReportID){
        return damageRepository.findReport(damageReportID);
    }

    public void deleteReport(int damageReportID){
        damageRepository.deleteReport(damageReportID);
    }


}
