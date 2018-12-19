package com.jp2.domain;

import com.jp2.domain.enumerations.RepairType;
import com.jp2.domain.enumerations.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="REPAIRS")
public class Repair {
    @Id
    @Column(name="ID_REPAIR",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long repairID;

    @Column(name="STATUS")
    private Status status;

    @Column(name="DATE")
    private Date date;

    @Column(name="TYPE")
    private RepairType repairtype;

    @Column(name="PRICE")
    private double price;

    @Column(name="DESCRIPTION")
    private String description;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ID_OWNER")
    private Owner owner;

    public Repair() {
    }

    public Repair(Status status, Date date, RepairType repairtype, double price, String description, Owner owner) {
        this.status = status;
        this.date = date;
        this.repairtype = repairtype;
        this.price = price;
        this.description = description;
        this.owner = owner;
    }

    public long getRepairID() {
        return repairID;
    }

    public void setRepairID(long repairID) {
        this.repairID = repairID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
