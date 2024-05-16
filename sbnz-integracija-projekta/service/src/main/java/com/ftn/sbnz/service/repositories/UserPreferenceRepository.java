package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {

    UserPreference getUserPreferenceById(Long id);

    UserPreference getUserPreferenceByUser(User user);

}