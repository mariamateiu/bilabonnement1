package com.example.bilabonnement1.model;

//Lavet af Maria

public class Car {
    private int carID;
    private String brand;
    private String model;
    private String VIN;
    private int diesel;
    private int gas;
    private int kmL;
    private int manual;
    private int CO2gkm;
    private int available;


    public Car(int carID, String brand, String model, String VIN, int diesel, int gas, int kmL, int manual, int CO2gkm, int available) {
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

    public int getDiesel() {
        return diesel;
    }

    public void setDiesel(int diesel) {
        this.diesel = diesel;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getKmL() {
        return kmL;
    }

    public void setKmL(int kmL) {
        this.kmL = kmL;
    }

    public int getManual() {
        return manual;
    }

    public void setManual(int manual) {
        this.manual = manual;
    }

    public int getCO2gkm() {
        return CO2gkm;
    }

    public void setCO2gkm(int CO2gkm) {
        this.CO2gkm = CO2gkm;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
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
