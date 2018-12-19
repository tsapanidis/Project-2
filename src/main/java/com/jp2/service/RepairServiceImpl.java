package com.jp2.service;

import com.jp2.model.RepairModel;
import com.jp2.repository.RepairRepository;
import com.jp2.domain.Repair;
import com.jp2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements  RepairService {
    @Autowired
    private RepairRepository repository;

    @Autowired
    private UserRepository userRepository;

    private SimpleDateFormat sdfr = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    @Override
    public List<Repair> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Repair> findByDate(Date date) {
        return repository.getRepairsByDate(date);
    }

    @Override
    public List<Repair> findByVAT(int vat) {
        return repository.getRepairsByOwnerVat(vat);
    }

    @Override
    public List<Repair> findByPlate(String plate) {
        return repository.getRepairsByOwnerPlate(plate);
    }

    @Override
    public List<Repair> findByDateBetween(Date first, Date last) {
        return repository.getRepairsByDateBetween(first,last);
    }

    @Override
    public List<Repair> getfirst10Repairs() {
        return repository.getRepairsByDateAfterOrderByDate(new Date()).stream().limit(10).collect(Collectors.toList());
    }

    @Override
    public Optional<Repair> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void Delete(long i){
        repository.deleteById(i);
    }

    @Override
    public void Create (RepairModel repairModel) throws ParseException {

        Repair repair = new Repair(repairModel.getStatus(),sdfr.parse(repairModel.getDate()),repairModel.getRepairtype(),repairModel.getPrice(),repairModel.getDescription(),userRepository.getOwnerByVat(Integer.parseInt(repairModel.getVat())).get());
        repository.saveAndFlush(repair);
    }

    @Override
    public void Update (RepairModel repairModel) throws ParseException {

        Repair repair = repository.findById(repairModel.getID()).get();
        //repair.setRepairID(repairModel.getID());
        repair.setStatus(repairModel.getStatus());
        repair.setDate(sdfr.parse(repairModel.getDate()));
        repair.setRepairtype(repairModel.getRepairtype());
        repair.setPrice(repairModel.getPrice());
        repair.setDescription(repairModel.getDescription());
        int vat = Integer.parseInt(repairModel.getVat());
        repair.setOwner(userRepository.getOwnerByVat(Integer.parseInt(repairModel.getVat())).get());
        repository.saveAndFlush(repair);
    }
}
