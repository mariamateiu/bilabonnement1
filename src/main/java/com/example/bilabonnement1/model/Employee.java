package com.example.bilabonnement1.model;

public class Employee {
    private int employeeID;
    private String fullName;
    private String password;
    private String type;

    public Employee(){}
    public Employee(String fullName, String password, String type) {
        this.fullName = fullName;
        this.password = password;
        this.type = type;
    }

    public Employee(int employeeID, String fullName, String password, String type) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.password = password;
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
                "fullName=" + fullName +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
