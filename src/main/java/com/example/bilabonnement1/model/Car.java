package com.example.bilabonnement1.model;

public class Car {
    private int carID;
    private String brand;
    private String model;
    private String VIN;
    private boolean diesel;
    private boolean gas;
    private double kmL;
    private boolean manual;
    private double CO2gkm;
    private boolean available;

    public Car(int carID, String brand, String model, String VIN, boolean diesel, boolean gas, double kmL, boolean manual, double CO2gkm, boolean available) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.VIN = VIN;
        this.diesel = diesel;
        this.gas = gas;
        this.kmL = kmL;
        this.manual = manual;
        this.CO2gkm = CO2gkm;
        this.available = available;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public boolean isDiesel() {
        return diesel;
    }

    public void setDiesel(boolean diesel) {
        this.diesel = diesel;
    }

    public boolean isGas() {
        return gas;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public double getKmL() {
        return kmL;
    }

    public void setKmL(double kmL) {
        this.kmL = kmL;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public double getCO2gkm() {
        return CO2gkm;
    }

    public void setCO2gkm(double CO2gkm) {
        this.CO2gkm = CO2gkm;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", VIN='" + VIN + '\'' +
                ", diesel=" + diesel +
                ", gas=" + gas +
                ", kmL=" + kmL +
                ", manual=" + manual +
                ", CO2gkm=" + CO2gkm +
                ", available=" + available +
                '}';
    }
}
