package Repository;

import Model.Employee;
import Utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataEmployeeRepository {
    ConnectionManager cm = new ConnectionManager();

    public void createDTE(Employee datEm) throws SQLException {
        Connection connection = cm.connectionToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.employee(employeeID, password) VALUES (?,?,?)");
        preparedStatement.setInt(1, datEm.getEmployeeID());
        preparedStatement.setString(2, datEm.getPassword());
        preparedStatement.setString(3, "Data");
        preparedStatement.executeUpdate();
    }
}
