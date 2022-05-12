package Model;

public class Lease {
    private int leaseID;
    private int clientID;
    private int carID;
    private int VIN; //vehicle identification number
    private int price;
    private boolean limitedLease;
    private boolean unlimitedLease;
    private int limitedLeaseTime;
    private int unlimitedLeaseTime;

    public Lease(int leaseID, int clientID, int carID, int VIN, int price, boolean limitedLease, boolean unlimitedLease, int limitedLeaseTime, int unlimitedLeaseTime) {
        this.leaseID = leaseID;
        this.clientID = clientID;
        this.carID = carID;
        this.VIN = VIN;
        this.price = price;
        this.limitedLease = limitedLease;
        this.unlimitedLease = unlimitedLease;
        this.limitedLeaseTime = limitedLeaseTime;
        this.unlimitedLeaseTime = unlimitedLeaseTime;
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

    public boolean isUnlimitedLease() {
        return unlimitedLease;
    }

    public void setUnlimitedLease(boolean unlimitedLease) {
        this.unlimitedLease = unlimitedLease;
    }

    public int getLimitedLeaseTime() {
        return limitedLeaseTime;
    }

    public void setLimitedLeaseTime(int limitedLeaseTime) {
        this.limitedLeaseTime = limitedLeaseTime;
    }

    public int getUnlimitedLeaseTime() {
        return unlimitedLeaseTime;
    }

    public void setUnlimitedLeaseTime(int unlimitedLeaseTime) {
        this.unlimitedLeaseTime = unlimitedLeaseTime;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "leaseID=" + leaseID +
                ", clientID=" + clientID +
                ", carID=" + carID +
                ", VIN=" + VIN +
                ", price=" + price +
                ", limitedLease=" + limitedLease +
                ", unlimitedLease=" + unlimitedLease +
                ", limitedLeaseTime=" + limitedLeaseTime +
                ", unlimitedLeaseTime=" + unlimitedLeaseTime +
                '}';
    }
}
