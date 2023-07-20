package com.mantis.service;

import com.mantis.logic.UserLogic;
import com.mantis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
class TokenService {
    @Autowired
    UserLogic userLogic;
    UserMapper userMapper = new UserMapper();

    @PreAuthorize("hasAuthority('Admin')")
    public  String performUserTask(){
        return ("User successfully registered ");

    }
    //dbden kullanıcı idsi geliyo rolleri gliyor her yetkisi gelcek listeye ekleriz get ile alırız. simplegranteedauthoritynin içine listeeyi doldur. web security içine request koyuyoruz.
}
