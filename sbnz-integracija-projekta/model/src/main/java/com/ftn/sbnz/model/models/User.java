package com.ftn.sbnz.model.models;

import java.util.List;

import com.ftn.sbnz.model.events.Event;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToOne(mappedBy = "user")
    private UserPreference preference;

    @OneToMany(mappedBy = "ratedBy")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user")
    private List<Event> events;

}
