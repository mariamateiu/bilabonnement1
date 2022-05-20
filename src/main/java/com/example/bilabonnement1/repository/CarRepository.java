package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.Car;
import com.example.bilabonnement1.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarRepository {
    ConnectionManager cm = new ConnectionManager();

    public void chooseCar(Car car) throws SQLException {

        Connection connection = cm.connectionToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.Car(carID, brand, model, VIN, diesel, gas, kmL, manual, CO2gkm, available) VALUES (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, car.getCarID());
        preparedStatement.setString(2, car.getBrand());
        preparedStatement.setString(3, car.getModel());
        preparedStatement.setString(4, car.getVIN());
        preparedStatement.setBoolean(5, car.isDiesel());
        preparedStatement.setBoolean(6, car.isGas());
        preparedStatement.setDouble(7, car.getKmL());
        preparedStatement.setBoolean(8, car.isManual());
        preparedStatement.setDouble(9, car.getCO2gkm());
        preparedStatement.setBoolean(10, car.isAvailable());

        preparedStatement.executeUpdate();

    }
}
