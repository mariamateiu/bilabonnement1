package com.example.bilabonnement1.model;

public class DamageRegistration {
    private int damageRegistrationID;
    private int leaseID;
    private int damageReportID;


    public DamageRegistration(int damageRegistrationID, int leaseID, int damageReportID) {
        this.damageRegistrationID = damageRegistrationID;
        this.leaseID = leaseID;
        this.damageReportID = damageReportID;
    }

    public int getDamageRegistrationID() {
        return damageRegistrationID;
    }

    public void setDamageRegistrationID(int damageRegistrationID) {
        this.damageRegistrationID = damageRegistrationID;
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    public int getDamageReportID() {
        return damageReportID;
    }

    public void setDamageReportID(int damageReportID) {
        this.damageReportID = damageReportID;
    }

    @Override
    public String toString() {
        return "DamageRegistration{" +
                "damageRegistrationID=" + damageRegistrationID +
                ", leaseID=" + leaseID +
                ", damageReportID=" + damageReportID +
                '}';
    }
}
