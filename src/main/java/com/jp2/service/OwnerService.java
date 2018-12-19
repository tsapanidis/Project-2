package com.jp2.service;

import com.jp2.model.LoginResponse;
import com.jp2.model.OwnerModel;
import com.jp2.domain.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    List<Owner> findAll();

    Optional<Owner> findByVat(int VAT);

    Optional<Owner> findByMail(String mail);

    Optional<Owner> findById(long id);

    void Delete(long i);

    void Create (OwnerModel ownerModel);

    void Update (OwnerModel ownerModel);

    LoginResponse login(String email,String password);

    void logout(String username, String password);

}
