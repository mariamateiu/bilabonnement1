package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusinessEmployeeRepository {
    ConnectionManager cm = new ConnectionManager();

    public void createBE(Employee BE) throws SQLException {
        Connection connection = cm.connectionToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.employee(employeeID, password, type, full_name) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, BE.getEmployeeID());
        preparedStatement.setString(2, BE.getPassword());
        preparedStatement.setString(3,"Business");
        preparedStatement.setString(4,BE.getFullName());
        preparedStatement.executeUpdate();
    }
}
