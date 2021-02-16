package com.workshop.db.repository;

import com.workshop.db.entity.BrakeHydraulic;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrakeHydraulicRepository extends PagingAndSortingRepository<BrakeHydraulic, Long>, JpaSpecificationExecutor<BrakeHydraulic> {
}
