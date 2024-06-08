package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
