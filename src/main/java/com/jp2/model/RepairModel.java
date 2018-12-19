package com.jp2.model;

import com.jp2.domain.enumerations.RepairType;
import com.jp2.domain.enumerations.Status;

public class RepairModel {
    private String vat;
    private String date;
    private Status status;
    private double price;
    private RepairType repairtype;
    private String description;
    private long ID;

    public long getID() {
        return ID;
    }

    public void setID(long repairID) {
        this.ID = repairID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RepairType getRepairtype() {
        return repairtype;
    }

    public void setRepairtype(RepairType repairtype) {
        this.repairtype = repairtype;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "" +
                "Status: " + status +
                " | Date: " + date +
                " | Repairtype: " + repairtype +
                " | Price: " + price +
                " | Description: '" + description+"\'"+
                " | Customer VAT: "+vat;
    }
}
