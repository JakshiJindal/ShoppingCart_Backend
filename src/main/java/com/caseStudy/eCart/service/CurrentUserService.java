package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.UsersRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
@Service
public class CurrentUserService {
    @Autowired
    private UsersRepository usersRepository;


    public Long getUserId(Principal principal)
    {
        String email=principal.getName();
        Long id=usersRepository.findByUsername(email).get().getUserid();
        return id;
    }
    public users getUserProfile(Principal principal) {
        Optional<users> myp=usersRepository.findByUsername(principal.getName());
        return myp.get();
    }


 /*public ResponseEntity<?> checkDetails(users user,Principal principal) {
        Optional<users> usercheck=usersRepository.findByUsername(principal.getName());
        Optional<users> usercheckinfo=usersRepository.findByUsername(users.getUsername());
        if(usercheckinfo.isPresent()& usercheckinfo.get().getUsername()!=usercheck.get().getUsername());
        HttpHeaders responseHeaders=new HttpHeaders();
    }*/

}

