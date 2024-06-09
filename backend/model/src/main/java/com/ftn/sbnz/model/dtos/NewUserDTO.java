package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.models.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUserDTO {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Role role;

}
