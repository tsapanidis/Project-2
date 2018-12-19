package com.jp2.repository;

import com.jp2.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> getRepairsByDate(Date date);

    List<Repair> getRepairsByOwnerVat(int VAT);

    List<Repair> getRepairsByOwnerPlate(String Plate);

    List<Repair> getRepairsByDateBetween(Date first,Date Last);

    List<Repair> getRepairsByDateAfterOrderByDate(Date date);
}

