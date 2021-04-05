package com.workshop.config.security.repository;

import com.workshop.config.security.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ServiceUser, Long> {

    @Query("select u from ServiceUser u left join fetch u.roles where upper(u.username) = upper(:username)")
    Optional<ServiceUser> findByUser(@Param("username") String username);

    boolean existsByUsername(String userName);
}
