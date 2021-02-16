package com.workshop.db.repository;

import com.workshop.db.entity.BottomBracket;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BottomBracketRepository extends PagingAndSortingRepository<BottomBracket, Long>, JpaSpecificationExecutor<BottomBracket> {
}
