package com.workshop.db.repository;

import com.workshop.db.entity.Chain;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends PagingAndSortingRepository<Chain, Long>, JpaSpecificationExecutor<Chain> {
}
