package com.workshop.db.repository;

import com.workshop.db.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image, Long> {


}
