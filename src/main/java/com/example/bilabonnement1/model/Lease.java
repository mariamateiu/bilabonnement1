package com.example.bilabonnement1.model;

public class Lease {
    private int leaseID;
    private int clientID;
    private int carID;
    private int price;
    private boolean limitedLease;
    private int monthLeased;

    public Lease() {}

    public Lease(int clientID, int carID, int price) {
        this.clientID = clientID;
        this.carID = carID;
        this.price = price;
    }

    public Lease(int leaseID, int clientID, int carID, int price) {
        this.leaseID = leaseID;
        this.clientID = clientID;
        this.carID = carID;
        this.price = price;
    }



    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isLimitedLease() {
        return limitedLease;
    }

    public void setLimitedLease(boolean limitedLease) {
        this.limitedLease = limitedLease;
    }

    public int getMonthLeased() {
        return monthLeased;
    }

    public void setMonthLeased(int monthLeased) {
        this.monthLeased = monthLeased;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "leaseID=" + leaseID +
                ", clientID=" + clientID +
                ", carID=" + carID +
                ", price=" + price +
                ", limitedLease=" + limitedLease +
                ", unlimitedLeaseTime=" + monthLeased +
                '}';
    }
}
