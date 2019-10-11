package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.Exception.ResourceNotFound;
import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.SignUpRepository;
import com.caseStudy.eCart.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")

public class SignUpController {
    @Autowired
    UsersRepository p;
    @PostMapping("/addUser")
    public users createuser(@Valid @RequestBody users user) {
        user.setRole("user");
        user.setActive(1);
        return p.save(user);
    }
}
