package Model;

public class DamageReport {
    private int damageReportID;
    private int carID;
    private String carPart;
    private String damageDescription;
    private String damagePrice;

    public DamageReport(int damageReportID, int carID, String carPart, String damageDescription, String damagePrice) {
        this.damageReportID = damageReportID;
        this.carID = carID;
        this.carPart = carPart;
        this.damageDescription = damageDescription;
        this.damagePrice = damagePrice;
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
