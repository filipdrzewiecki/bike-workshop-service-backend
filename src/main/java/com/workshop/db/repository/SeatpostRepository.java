package com.workshop.db.repository;

import com.workshop.db.entity.Seatpost;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatpostRepository extends PagingAndSortingRepository<Seatpost, Long>, JpaSpecificationExecutor<Seatpost> {
}
