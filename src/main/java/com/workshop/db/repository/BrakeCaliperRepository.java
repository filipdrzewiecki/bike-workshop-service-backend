package com.workshop.db.repository;

import com.workshop.db.entity.BrakeCaliper;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrakeCaliperRepository extends PagingAndSortingRepository<BrakeCaliper, Long>, JpaSpecificationExecutor<BrakeCaliper> {
}
