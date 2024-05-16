package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);

    User getUserByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);


}