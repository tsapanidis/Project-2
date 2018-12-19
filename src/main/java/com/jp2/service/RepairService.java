package com.jp2.service;

import com.jp2.model.RepairModel;
import com.jp2.domain.Repair;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RepairService {

    List<Repair> findAll();

    List<Repair> findByDate(Date date);

    List<Repair> findByVAT(int vat);

    List<Repair> findByPlate(String plate);

    List<Repair> findByDateBetween(Date first,Date last);

    List<Repair> getfirst10Repairs();
    Optional<Repair> findById(long id);

    void Delete(long i);

    void Create (RepairModel repairModel) throws ParseException;

    void Update (RepairModel repairModel) throws ParseException;
}
