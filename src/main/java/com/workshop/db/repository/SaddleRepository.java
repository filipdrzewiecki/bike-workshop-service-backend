package com.workshop.db.repository;

import com.workshop.db.entity.Saddle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaddleRepository extends PagingAndSortingRepository<Saddle, Long>, JpaSpecificationExecutor<Saddle> {
}
