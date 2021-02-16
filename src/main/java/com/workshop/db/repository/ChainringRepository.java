package com.workshop.db.repository;

import com.workshop.db.entity.Chainring;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainringRepository extends PagingAndSortingRepository<Chainring, Long>, JpaSpecificationExecutor<Chainring> {
}
