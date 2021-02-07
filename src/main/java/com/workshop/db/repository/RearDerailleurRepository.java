package com.workshop.db.repository;

import com.workshop.db.entity.RearDerailleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RearDerailleurRepository extends JpaRepository<RearDerailleur, Long>, JpaSpecificationExecutor<RearDerailleur> {

    // For db backup in test only
    List<RearDerailleur> findAllByIsOfficialTrue();
}
