package com.example.bilabonnement1.service;

import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.LejeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaseService {
    @Autowired
    LejeRepository lejeRepository;


    public ArrayList<Lease> getAllLeases(){
        ArrayList<Lease> leases = lejeRepository.getAllLeases();

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
