package com.example.bilabonnement1.service;

import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Lavet af Maria

@Service
public class LeaseService {
    @Autowired
    LeaseRepository leaseRepository = new LeaseRepository();


    public ArrayList<Lease> getAllLeases(){
        ArrayList<Lease> leases = leaseRepository.getAllLeases();

        return leases;
    }

    public int getTotalPrice(List<Lease> leaseList){

        int totalPrice = 0;
        for (int i = 0; i < leaseList.size(); i++) {
            totalPrice+= leaseList.get(i).getPrice();

        }
        return totalPrice;
    }




}
