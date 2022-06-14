package com.example.bilabonnement1.service;

import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Lavet af Maria

@Service
public class LeaseService {
    LeaseRepository leaseRepository;

    @Autowired
    public LeaseService(LeaseRepository leaseRepository){
        this.leaseRepository = leaseRepository;
    }



    public void createLease(Lease lease) throws SQLException {
        leaseRepository.createLease(lease);
    }

    public ArrayList<Lease> getAllLeases(){
        ArrayList<Lease> leases = leaseRepository.getAllLeases();

        return leases;
    }

    public Lease findLease(int leaseID){
        return leaseRepository.findLease(leaseID);
    }

    public void deleteLease(int leaseID){
        leaseRepository.deleteLease(leaseID);
    }

    public int getTotalPrice(List<Lease> leaseList){

        int totalPrice = 0;
        for (int i = 0; i < leaseList.size(); i++) {
            totalPrice+= leaseList.get(i).getPrice();

        }
        return totalPrice;
    }




}
