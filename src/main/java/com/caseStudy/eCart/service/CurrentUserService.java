package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
@Service
public class CurrentUserService {
    @Autowired
    private UsersRepository usersRepository;

    public Optional<users> CurrentUser(Principal principal) {
        String email=principal.getName();
        return usersRepository.findByUsername(email);
    }
    public Long getUserId(Principal principal)
    {
        String email=principal.getName();
        Long id=usersRepository.findByUsername(email).get().getUserid();
        return id;
    }
 public String getUserRole(Principal principal) {
        return usersRepository.findByUsername(principal.getName()).get().getRole();//.getRoleid();
    }

    public Optional<users> getUserProfile(Principal principal) {
        return usersRepository.findByUsername(principal.getName());
    }
 /*public ResponseEntity<?> checkDetails(users user,Principal principal) {
        Optional<users> usercheck=usersRepository.findByUsername(principal.getName());
        Optional<users> usercheckinfo=usersRepository.findByUsername(users.getUsername());
        if(usercheckinfo.isPresent()& usercheckinfo.get().getUsername()!=usercheck.get().getUsername());
        HttpHeaders responseHeaders=new HttpHeaders();
    }*/

}
