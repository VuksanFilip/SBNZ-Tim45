package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    Rating getRatingById(Long id);

}