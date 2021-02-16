package com.workshop.db.repository;

import com.workshop.db.entity.HeadSet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadsetRepository extends PagingAndSortingRepository<HeadSet, Long>, JpaSpecificationExecutor<HeadSet> {
}
