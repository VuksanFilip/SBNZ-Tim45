package com.ftn.sbnz.model.repositories;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
    UserPreference getUserPreferenceById(Long id);
    UserPreference getUserPreferenceByUser(User user);

}