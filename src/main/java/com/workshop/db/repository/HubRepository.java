package com.workshop.db.repository;

import com.workshop.db.entity.Hub;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HubRepository extends PagingAndSortingRepository<Hub, Long>, JpaSpecificationExecutor<Hub> {
}
