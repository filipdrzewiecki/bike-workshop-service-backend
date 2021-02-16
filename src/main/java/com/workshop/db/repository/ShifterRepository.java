package com.workshop.db.repository;

import com.workshop.db.entity.Shifter;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShifterRepository extends PagingAndSortingRepository<Shifter, Long>, JpaSpecificationExecutor<Shifter> {
}
