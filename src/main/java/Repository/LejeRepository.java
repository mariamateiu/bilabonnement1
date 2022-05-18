package Repository;

import Model.Lease;
import Utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LejeRepository {

    ConnectionManager cm = new ConnectionManager();

    public void createLeje(Lease lease) throws SQLException {

        Connection connection = cm.connectionToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.lease(leaseID, clientID, carID, VIN, price, limited, month_leased) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, lease.getLeaseID());
        preparedStatement.setInt(2, lease.getClientID());
        preparedStatement.setInt(3, lease.getCarID());
        preparedStatement.setInt(4, lease.getVIN());
        preparedStatement.setInt(5, lease.getPrice());
        preparedStatement.setBoolean(6, lease.isLimitedLease());
        preparedStatement.setInt(7, lease.getMonthLeased());

        preparedStatement.executeUpdate();

    }
}
