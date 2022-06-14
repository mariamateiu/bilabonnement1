package com.example.bilabonnement1.service;


import com.example.bilabonnement1.model.Car;
import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Lavet af Naomi
@Service
public class CarService {
    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // vi bruger vores service lag som vores sikkerhedslag
    public ArrayList<Car> allLeasedCar() {
        ArrayList<Car> cars = carRepository.allLeasedCar();

        return cars;
    }

    public ArrayList<Car> allLeasedCarAvailable() {
        ArrayList<Car> cars = carRepository.allLeasedCarAvailable();

        return cars;
    }

    public ArrayList<Car> allLeasedCarNotAvailable() {
        ArrayList<Car> cars = carRepository.allLeasedCarNotAvailable();

        return cars;
    }

    public Car findCar(int carID) {
        return carRepository.findCar(carID);
    }

    public Boolean carFound(int carID) throws SQLException {
        Boolean succes = false;
        Car car = carRepository.findCar(carID);
        if (car != null) {
            succes = true;
        }
        return succes;
    }

    public void carLeased(int carID, int carAvailable) {
        carRepository.carLeased(carID, carAvailable);
    }


}
