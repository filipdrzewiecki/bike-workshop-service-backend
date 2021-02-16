package com.workshop.db.repository;

import com.workshop.db.entity.Rim;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RimRepository extends PagingAndSortingRepository<Rim, Long>, JpaSpecificationExecutor<Rim> {
}
