package com.ftn.sbnz.model.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
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

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
