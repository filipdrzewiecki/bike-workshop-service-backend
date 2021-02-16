package com.workshop.db.repository;

import com.workshop.db.entity.Damper;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamperRepository extends PagingAndSortingRepository<Damper, Long>, JpaSpecificationExecutor<Damper> {
}
