package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.DamageRegistration;
import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DamageRepository {


    ConnectionManager cm = new ConnectionManager();

    public void createDamageRegistration( DamageRegistration damageRegistration) throws SQLException {
        Connection connection = cm.connectionToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.damageregistration(damageregistrationID, leaseID, damagereportID) VALUES (?,?,?)");

        preparedStatement.setInt(1,damageRegistration.getDamageRegistrationID());
        preparedStatement.setInt(2,damageRegistration.getLeaseID());
        preparedStatement.setInt(3,damageRegistration.getDamageReportID());


        preparedStatement.executeUpdate();

    }

    public void createDamageReport( DamageReport damageReport) throws SQLException {
        Connection connection = cm.connectionToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.damagereport(damageReportID, carID, car_part, damage_description, damage_price) VALUES (?,?,?,?,?)");

        preparedStatement.setInt(1,damageReport.getDamageReportID());
        preparedStatement.setInt(2,damageReport.getCarID());
        preparedStatement.setString(3,damageReport.getCarPart());
        preparedStatement.setString(4,damageReport.getDamageDescription());
        preparedStatement.setString(5,damageReport.getDamagePrice());

        preparedStatement.executeUpdate();

    }






}
