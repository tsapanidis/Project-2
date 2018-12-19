package com.jp2.service;

import com.jp2.exceptions.OwnerNotFoundException;
import com.jp2.model.LoginResponse;
import com.jp2.model.OwnerModel;
import com.jp2.repository.UserRepository;
import com.jp2.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{
    @Autowired
    private UserRepository repository;

    @Override
    public void Delete(long i){
        repository.deleteById(i);
    }

    @Override
    public void Create(OwnerModel ownerModel) {
        Owner owner = new Owner(ownerModel.getFirstName(),ownerModel.getLastName(),ownerModel.getAddress(),ownerModel.getEmail(),ownerModel.getPassword(),ownerModel.getBrand(),ownerModel.getPlate(),ownerModel.getVAT(),ownerModel.getUsertype());
       repository.saveAndFlush(owner);
    }

    @Override
    public void Update(OwnerModel ownerModel) {
        Owner owner = repository.findById(ownerModel.getID()).orElseThrow(OwnerNotFoundException::new);
        //owner.setOwnerID(ownerModel.getID());
        owner.setFirstName(ownerModel.getFirstName());
        owner.setLastName(ownerModel.getLastName());
        owner.setAddress(ownerModel.getAddress());
        owner.setEmail(ownerModel.getEmail());
        owner.setPassword(ownerModel.getPassword());
        owner.setBrand(ownerModel.getBrand());
        owner.setPlate(ownerModel.getPlate());
        owner.setVAT(ownerModel.getVAT());
        owner.setUsertype(ownerModel.getUsertype());
        repository.saveAndFlush(owner);

    }

    @Override
    public LoginResponse login(String email, String password) {
        Owner owner = repository.getOwnerByEmail(email).orElseThrow(OwnerNotFoundException::new);
        if (owner.getPassword().equals(password)) {
            return new LoginResponse(owner.getEmail(), owner.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(owner.getUsertype().name())));
        }
            return null;
    }

    @Override
    public void logout(String username, String password) {
        return;
    }

    @Override
    public List<Owner> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Owner> findByVat(int VAT){
        return repository.getOwnerByVat(VAT);
    }

    @Override
    public Optional<Owner> findByMail(String mail){
        return repository.getOwnerByEmail(mail);
    }

    @Override
    public Optional<Owner> findById(long id) {
        return repository.findById(id);
    }
}
