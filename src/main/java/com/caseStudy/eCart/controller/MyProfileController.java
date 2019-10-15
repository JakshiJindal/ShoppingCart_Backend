package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.CartRepository;
import com.caseStudy.eCart.repository.UsersRepository;
import com.caseStudy.eCart.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/userq")

public class MyProfileController {
    @Autowired
    CartRepository cart;
    @Autowired
    UsersRepository userrepo;
    @Autowired
    CurrentUserService cus;
    @RequestMapping(value="/myprofile", method = RequestMethod.GET)
    @ResponseBody
    public users getUserData(Principal principal) {
        return cus.getUserProfile(principal);
    }
    @RequestMapping(value="/updateUserData", method = RequestMethod.PUT)
    @ResponseBody
    public users updateUserData(@Valid @RequestBody users users) {
        users.setActive(1);
        userrepo.save(users);
        return users;
    }
}
