package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.AuthenticationRequestDTO;
import com.ftn.sbnz.model.dtos.AuthenticationResponseDTO;
import com.ftn.sbnz.model.dtos.NewUserDTO;
import com.ftn.sbnz.model.dtos.UserDTO;

public interface AuthService {

    AuthenticationResponseDTO login(AuthenticationRequestDTO requestDTO);

    UserDTO register(NewUserDTO newUserDTO);

}
