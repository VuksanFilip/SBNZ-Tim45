package com.ftn.sbnz.model.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Rating {
    @Id
    private Long id;
    @OneToOne
    private User user;
    private int rating;
    private String comment;
}
