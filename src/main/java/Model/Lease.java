package Model;

public class Lease {
    private int leaseID;
    private int customerID;
    private int carID;
    private int VIN; //vehicle identification number
    private int price;
    private boolean limitedLease;
    private int monthLeased;

    public Lease(int leaseID, int customerID, int carID, int VIN, int price, boolean limitedLease, int monthLeased) {
        this.leaseID = leaseID;
        this.customerID = customerID;
        this.carID = carID;
        this.VIN = VIN;
        this.price = price;
        this.limitedLease = limitedLease;
        this.monthLeased = monthLeased;
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
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
                ", clientID=" + customerID +
                ", carID=" + carID +
                ", VIN=" + VIN +
                ", price=" + price +
                ", limitedLease=" + limitedLease +
                ", unlimitedLeaseTime=" + monthLeased +
                '}';
    }
}
