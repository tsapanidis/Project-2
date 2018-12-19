package com.jp2.repository;

import com.jp2.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Owner,Long> {

    Optional<Owner> getOwnerByVat(int VAT);

    Optional<Owner> getOwnerByEmail(String email);
}
