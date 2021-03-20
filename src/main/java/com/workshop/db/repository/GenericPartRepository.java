package com.workshop.db.repository;

import com.workshop.db.entity.BicyclePart;
import com.workshop.enums.PartType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericPartRepository extends PagingAndSortingRepository<BicyclePart, Long>, JpaSpecificationExecutor<BicyclePart> {
}
