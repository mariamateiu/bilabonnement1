package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class DamageRepository {


    ConnectionManager cm = new ConnectionManager();

    public void createDamageReport( DamageReport damageReport) throws SQLException {
        Connection connection = cm.connectionToDB();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.damagereport(damagereportID, carID, car_part, damage_description, damage_price) VALUES (?,?,?,?,?)");

        preparedStatement.setInt(1,damageReport.getDamageReportID());
        preparedStatement.setInt(2,damageReport.getCarID());
        preparedStatement.setString(3,damageReport.getCarPart());
        preparedStatement.setString(4,damageReport.getDamageDescription());
        preparedStatement.setInt(5,damageReport.getDamagePrice());

        preparedStatement.executeUpdate();

    }

    public ArrayList<DamageReport> getAllReports() {
        Connection connection = cm.connectionToDB();

        ArrayList<DamageReport> reports = new ArrayList<>();
        String query = "SELECT * FROM damagereport";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int damagereportID = resultSet.getInt(1);
                int carID = resultSet.getInt(2);
                String carPart = resultSet.getString(3);
                String damageDescription = resultSet.getString(4);
                int damagePrice = resultSet.getInt(5);

                reports.add(new DamageReport(damagereportID,carID,carPart,damageDescription,damagePrice));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return reports;
    }

    public DamageReport findReport(int damageReportID){
            DamageReport damageReport = null;
        Connection connection = cm.connectionToDB();
            try {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM semestereksamen.damagereport WHERE damagereportID = '" + damageReportID + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int carID = resultSet.getInt("carID");
                    String carPart = resultSet.getString("car_part");
                    String damageDescription = resultSet.getString("damage_description");
                    int damagePrice = resultSet.getInt("damage_price");
                    damageReport = new DamageReport(damageReportID,carID,carPart,damageDescription,damagePrice);
                }
            } catch (SQLException e) {
                System.out.println("Kunne ikke finde report" + e);
            }
            return damageReport;
        }

    public void deleteReport(int damageReportID) {
        Connection connection = cm.connectionToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM semestereksamen.damagereport WHERE damagereportID=?");
            preparedStatement.setInt(1, damageReportID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("fejl" + e);

        }


    }

    }







