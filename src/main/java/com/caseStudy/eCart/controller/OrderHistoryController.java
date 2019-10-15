package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.orderHistory;
import com.caseStudy.eCart.repository.OrderHistoryRepository;
import com.caseStudy.eCart.service.CartService;
import com.caseStudy.eCart.service.CurrentUserService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHistoryController {
    OrderHistoryRepository orderhistory;
    private CurrentUserService currentUserService;
    private CartService cartService;

}

