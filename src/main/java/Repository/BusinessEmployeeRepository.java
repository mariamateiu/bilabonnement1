package Repository;

import Model.Employee;
import Utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusinessEmployeeRepository {
    ConnectionManager cm = new ConnectionManager();

    public void createBE(Employee BE) throws SQLException {
        Connection connection = cm.connectionToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.employee(employeeID, password, type) VALUES (?,?,?)");
        preparedStatement.setInt(1, BE.getEmployeeID());
        preparedStatement.setString(2, BE.getPassword());
        preparedStatement.setString(3,"Business");
        preparedStatement.executeUpdate();
    }
}
