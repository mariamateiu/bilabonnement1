package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class DamageRepository {

    ConnectionManager cm = new ConnectionManager();
    Connection connection = cm.connectionToDB();


    public void createDamageReport( DamageReport damageReport) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO damagereport(damagereportID, clientID, carID, car_part, damage_description, damage_price) VALUES (?,?,?,?,?,?)");

        preparedStatement.setInt(1,damageReport.getDamageReportID());
        preparedStatement.setInt(2,damageReport.getClientID());
        preparedStatement.setInt(3,damageReport.getCarID());
        preparedStatement.setString(4,damageReport.getCarPart());
        preparedStatement.setString(5,damageReport.getDamageDescription());
        preparedStatement.setInt(6,damageReport.getDamagePrice());

        preparedStatement.executeUpdate();

    }

    public ArrayList<DamageReport> getAllReports() {

        ArrayList<DamageReport> reports = new ArrayList<>();
        String query = "SELECT * FROM damagereport";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int damagereportID = resultSet.getInt(1);
                int clientID = resultSet.getInt(2);
                int carID = resultSet.getInt(3);
                String carPart = resultSet.getString(4);
                String damageDescription = resultSet.getString(5);
                int damagePrice = resultSet.getInt(6);

                reports.add(new DamageReport(damagereportID,clientID,carID,carPart,damageDescription,damagePrice));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return reports;
    }

    public DamageReport findReport(int damageReportID){
            DamageReport damageReport = null;
            try {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM semestereksamen.damagereport WHERE damagereportID = '" + damageReportID + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int carID = resultSet.getInt("carID");
                    int clientID = resultSet.getInt("clientID");
                    String carPart = resultSet.getString("car_part");
                    String damageDescription = resultSet.getString("damage_description");
                    int damagePrice = resultSet.getInt("damage_price");
                    damageReport = new DamageReport(damageReportID,clientID,carID,carPart,damageDescription,damagePrice);
                }
            } catch (SQLException e) {
                System.out.println("Kunne ikke finde report" + e);
            }
            return damageReport;
        }

    public void deleteReport(int damageReportID) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM semestereksamen.damagereport WHERE damagereportID=?");
            preparedStatement.setInt(1, damageReportID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("fejl" + e);

        }


    }

    }







