package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.events.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "regular_users")
public class RegularUser extends User{

    @OneToOne(mappedBy = "user")
    private UserPreference preference;

    @OneToMany(mappedBy = "ratedBy")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user")
    private List<Event> events;

    @OneToMany(mappedBy = "user")
    private List<Recommendation> recommendations;

}
