package com.workshop.db.repository;

import com.workshop.db.entity.Crank;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrankRepository extends PagingAndSortingRepository<Crank, Long>, JpaSpecificationExecutor<Crank> {
}
