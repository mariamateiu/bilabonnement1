package Repository;

import Model.Employee;
import Utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DamageEmployeeRepository {

    ConnectionManager cm = new ConnectionManager();

    public void createDME(Employee DamEm) throws SQLException {
        Connection connection = cm.connectionToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.employee(employeeID, password, type) VALUES (?,?,?)");
        preparedStatement.setInt(1, DamEm.getEmployeeID());
        preparedStatement.setString(2, DamEm.getPassword());
        preparedStatement.setString(3,"Damage");
        preparedStatement.executeUpdate();
    }
}
