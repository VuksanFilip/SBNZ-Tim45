package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.RegularUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {
}
