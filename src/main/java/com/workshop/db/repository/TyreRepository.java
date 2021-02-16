package com.workshop.db.repository;

import com.workshop.db.entity.Tyre;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TyreRepository extends PagingAndSortingRepository<Tyre, Long>, JpaSpecificationExecutor<Tyre> {
}
