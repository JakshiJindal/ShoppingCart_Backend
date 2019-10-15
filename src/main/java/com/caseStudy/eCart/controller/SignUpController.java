package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.UsersRepository;
import com.caseStudy.eCart.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")

public class SignUpController {
    @Autowired
    UsersRepository p;
    @Autowired
    CurrentUserService cus;

    @PostMapping("/addUser")
    public users createuser(@Valid @RequestBody users user) {
        user.setRole("user");
        user.setActive(1);
        return p.save(user);
    }
}
