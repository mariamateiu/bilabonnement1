package com.example.bilabonnement1.model;

public class DamageReport {
    private int damageReportID;
    private int carID;
    private String carPart;
    private String damageDescription;
    private String damagePrice;
    private int customerID;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public DamageReport(){
    }

    public int getDamageReportID() {
        return damageReportID;
    }

    public void setDamageReportID(int damageReportID) {
        this.damageReportID = damageReportID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarPart() {
        return carPart;
    }

    public void setCarPart(String carPart) {
        this.carPart = carPart;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public String getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(String damagePrice) {
        this.damagePrice = damagePrice;
    }

    @Override
    public String toString() {
        return "DamageReport{" +
                "damageReportID=" + damageReportID +
                ", carID=" + carID +
                ", carPart='" + carPart + '\'' +
                ", damageDescription='" + damageDescription + '\'' +
                ", damagePrice='" + damagePrice + '\'' +
                '}';
    }
}
