package com.workshop.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workshop.config.security.entity.ServiceUser;
import com.workshop.db.entity.Bicycle;

import java.util.List;
import java.util.Optional;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Long> {

    List<Bicycle> findAllByServiceUser(ServiceUser serviceUser);

    Optional<Bicycle> findByNameAndServiceUser(String name, ServiceUser serviceUser);

    boolean existsByNameAndServiceUser(String name, ServiceUser serviceUser);

}
