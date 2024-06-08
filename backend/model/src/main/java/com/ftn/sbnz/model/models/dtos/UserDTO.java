package com.ftn.sbnz.model.models.dtos;

import com.ftn.sbnz.model.models.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String username;

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .build();
    }

}
