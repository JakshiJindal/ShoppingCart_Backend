package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.UsersRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.Optional;

public class UserService {
    private UsersRepository usersRepository;

    public users CurrentUser(Principal principal) {
        String email=principal.getName();
        return usersRepository.findByUsername(email).get();
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

public users getUserProfile( Principal principal) {
        return usersRepository.findByUsername(principal.getName()).get();
}
/*public ResponseEntity<?> checkDetails(users user,Principal principal) {
        Optional<users> usercheck=usersRepository.findByUsername(principal.getName());
        Optional<users> usercheckinfo=usersRepository.findByUsername(users.getusername());
        if(usercheckinfo.isPresent()& usercheckinfo.get().getUsername()!=usercheck.get().getUsername());
    HttpHeaders responseHeaders=new HttpHeaders();
}*/

}

