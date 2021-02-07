package com.workshop.db.repository;

import com.workshop.db.entity.RearDerailleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RearDerailleurRepository extends JpaRepository<RearDerailleur, Long>, JpaSpecificationExecutor<RearDerailleur> {

}
