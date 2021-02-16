package com.workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.workshop.db.entity.Pedals;
import org.springframework.stereotype.Repository;

@Repository
public interface PedalsRepository extends PagingAndSortingRepository<Pedals, Long> {

}
