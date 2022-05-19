package com.example.bilabonnement1.model;

public class Employee {
    private int employeeID;
    private String password;
    private String type;




    public Employee(String username, String password, int employeeID, String type) {
        this.password = password;
        this.employeeID = employeeID;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
