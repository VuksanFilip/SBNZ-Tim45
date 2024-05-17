package com.ftn.sbnz.model.models;

import java.util.List;

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

    @OneToMany(mappedBy = "ratedBy", cascade = CascadeType.ALL)
    private List<Rating> ratings;

}
