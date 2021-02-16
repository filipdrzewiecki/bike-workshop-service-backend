package com.workshop.db.repository;

import com.workshop.db.entity.Cassette;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassetteRepository extends PagingAndSortingRepository<Cassette, Long>, JpaSpecificationExecutor<Cassette> {
}
