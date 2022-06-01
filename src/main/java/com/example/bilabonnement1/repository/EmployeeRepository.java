package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.Employee;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

//Lavet af Maria
public class EmployeeRepository {
    ConnectionManager cm = new ConnectionManager();
    Connection connection = cm.connectionToDB();


    public void createUser(Employee user) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO heroku_26b638a260d4157.employee(full_name, password, type) VALUES (?,?,?)");
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kunne ikke oprette" + e);
        }
    }

    public Employee findUser(String fullName) {
        Employee employee = null;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM heroku_26b638a260d4157.employee WHERE full_name = '" + fullName + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                String type = resultSet.getString("type");
                employee = new Employee(fullName, password, type);
            }
        } catch (SQLException e) {
            System.out.println("Kunne ikke finde bruger" + e);
        }
        return employee;
    }

    public ArrayList<Employee> getAllUsers() {
        Connection connection = cm.connectionToDB();

        ArrayList<Employee> users = new ArrayList<>();
        String query  = "SELECT * FROM heroku_26b638a260d4157.employee";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeID = resultSet.getInt(1);
                String fullName = resultSet.getString(2);
                String password = resultSet.getString(3);
                String type = resultSet.getString(4);


                users.add(new Employee(employeeID,fullName,password,type));
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return users;
    }

}
