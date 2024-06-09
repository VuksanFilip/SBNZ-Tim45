package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.models.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String firstName;

    private String lastName;

    private String username;

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .build();
    }

}
