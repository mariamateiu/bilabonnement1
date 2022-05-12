package Model;

public class Employee {
    private String username;
    private String password;
    private int employeeID;


    public Employee(String username, String password, int employeeID) {
        this.username = username;
        this.password = password;
        this.employeeID = employeeID;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeID=" + employeeID +
                '}';
    }
}
