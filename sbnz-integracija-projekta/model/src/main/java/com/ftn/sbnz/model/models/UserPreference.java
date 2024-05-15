package com.ftn.sbnz.model.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class UserPreference {
    @Id
    private Long id;
    private User user;
//    private String explicitPreferences;
//    private String implicitPreferences;
}
