package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.Car;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.utility.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class CarRepository {
    ConnectionManager cm = new ConnectionManager();

    /*
    public void chooseCar(Car car) throws SQLException {



    }

     */

    public ArrayList<Car> allLeasedCar(){
        Connection connection = cm.connectionToDB();

        ArrayList<Car> cars = new ArrayList<>();
        String query  = "SELECT * FROM car";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int carID = resultSet.getInt(1);
                String car_brand = resultSet.getString(2);
                String  car_model = resultSet.getString(3);
                String car_VIN = resultSet.getString(4);
                int car_diesel = resultSet.getInt(5);
                int car_gas = resultSet.getInt(6);
                int car_km_L = resultSet.getInt(7);
                int car_manual = resultSet.getInt(8);
                int car_CO2 = resultSet.getInt(9);
                int car_available = resultSet.getInt(10);
                cars.add(new Car(carID, car_brand, car_model, car_VIN, car_diesel, car_gas, car_km_L,car_manual, car_CO2, car_available));
                System.out.println(cars);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return cars;
    }

    public ArrayList<Car> allLeasedCarAvailable(){
        Connection connection = cm.connectionToDB();

        ArrayList<Car> cars = new ArrayList<>();
        String query  = "SELECT * FROM car where car_available = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int carID = resultSet.getInt(1);
                String car_brand = resultSet.getString(2);
                String  car_model = resultSet.getString(3);
                String car_VIN = resultSet.getString(4);
                int car_diesel = resultSet.getInt(5);
                int car_gas = resultSet.getInt(6);
                int car_km_L = resultSet.getInt(7);
                int car_manual = resultSet.getInt(8);
                int car_CO2 = resultSet.getInt(9);
                int car_available = resultSet.getInt(10);
                cars.add(new Car(carID, car_brand, car_model, car_VIN, car_diesel, car_gas, car_km_L,car_manual, car_CO2, car_available));
                System.out.println(cars);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return cars;
    }


    public ArrayList<Car> allLeasedCarNotAvailable(){
        Connection connection = cm.connectionToDB();

        ArrayList<Car> cars = new ArrayList<>();
        String query  = "SELECT * FROM car where car_available = 0";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int carID = resultSet.getInt(1);
                String car_brand = resultSet.getString(2);
                String  car_model = resultSet.getString(3);
                String car_VIN = resultSet.getString(4);
                int car_diesel = resultSet.getInt(5);
                int car_gas = resultSet.getInt(6);
                int car_km_L = resultSet.getInt(7);
                int car_manual = resultSet.getInt(8);
                int car_CO2 = resultSet.getInt(9);
                int car_available = resultSet.getInt(10);
                cars.add(new Car(carID, car_brand, car_model, car_VIN, car_diesel, car_gas, car_km_L,car_manual, car_CO2, car_available));
                System.out.println(cars);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return cars;
    }
    }


