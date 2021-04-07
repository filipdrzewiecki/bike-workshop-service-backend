package com.workshop.db.repository;

import com.workshop.config.security.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workshop.db.entity.Bicycle;

import java.util.List;
import java.util.Optional;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Long> {

    List<Bicycle> findAllByProfile(Profile profile);

    Optional<Bicycle> findByNameAndProfile(String name, Profile profile);

    boolean existsByNameAndProfile(String name, Profile profile);

}
