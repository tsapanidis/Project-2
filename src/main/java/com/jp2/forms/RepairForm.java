package com.jp2.forms;

import com.jp2.domain.enumerations.RepairType;
import com.jp2.domain.enumerations.Status;


import javax.validation.constraints.Pattern;

public class RepairForm {

    private static final String DATE_PATTERN = "[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}";

    private static  final String VAT_PATTERN = "[0-9]{9}";

    private long RepairID;
    @Pattern(regexp = DATE_PATTERN , message = "Invalid Date")
    private String date;
    private Status status;
    private RepairType repairType;

    private double price;

    @Pattern(regexp = VAT_PATTERN , message = "Invalid Vat")
    private String vat;
    private String description;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public RepairType getRepairType() {
        return repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }


    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRepairID() {
        return RepairID;
    }

    public void setRepairID(long repairID) {
        RepairID = repairID;
    }
}
