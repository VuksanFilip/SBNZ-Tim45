package com.ftn.sbnz.model.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationDTO{

    private String username;

    private String password;

}
