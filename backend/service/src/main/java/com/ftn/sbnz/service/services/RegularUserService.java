package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.model.models.RegularUser;

public interface RegularUserService {

    UserDTO getUser(Long id);

    RegularUser findRegularUserById(Long id);

}
