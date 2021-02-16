package com.workshop.db.repository;

import com.workshop.db.entity.Wheel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends PagingAndSortingRepository<Wheel, Long>, JpaSpecificationExecutor<Wheel> {
}
