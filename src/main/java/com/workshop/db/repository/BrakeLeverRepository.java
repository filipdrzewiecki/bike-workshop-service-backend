package com.workshop.db.repository;

import com.workshop.db.entity.BrakeLever;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrakeLeverRepository extends PagingAndSortingRepository<BrakeLever, Long>, JpaSpecificationExecutor<BrakeLever> {
}
