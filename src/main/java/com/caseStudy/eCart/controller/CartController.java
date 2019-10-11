package com.caseStudy.eCart.controller;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.repository.CartRepository;
import com.caseStudy.eCart.service.CartService;
import com.caseStudy.eCart.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CartController {
    private CartRepository cartRepository;
    private CartService cartService;
    private CurrentUserService currentUserService;

    @Autowired
    public CartController(CartService cartService, CurrentUserService currentUserService) {
        this.cartService = cartService;
        this.currentUserService = currentUserService;
    }


    @RequestMapping(value = "/addtocart/recieve/{productid}", method = RequestMethod.POST)
    @ResponseBody
    public String addtocart(@PathVariable Long productid, Principal principal) {
        return cartService.addtocart(currentUserService.getUserId(principal), productid);
    }

    @RequestMapping(value = "/showcart/recieve/{productid}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<cart> showcart(@PathVariable Long productid, Principal principal)
    {
        return cartService.showcart(productid,principal);
    }
@RequestMapping(value="/checkout/recieve",method= RequestMethod.GET)
    @ResponseBody
    public double checkout(Principal principal)
    {
        return cartService.checkout(currentUserService.getUserId(principal),principal);
    }

    @RequestMapping(value="/clearcart/recieve",method= RequestMethod.GET)
    @ResponseBody
    public String clearcart(Principal principal)
    {
        return cartService.clearcart(currentUserService.getUserId(principal),principal);
    }
    @RequestMapping(value="/removetocart/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public String removetocart(Principal principal,@PathVariable Long productid)
    {
        return cartService.removecart(currentUserService.getUserId(principal),productid);
    }
   /* @RequestMapping(value="/decreaseQuantity/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public String decreaseQuantity(Principal principal,@PathVariable Long productid)
    {
        return cartService.decreaseQuantity(productid,principal);
    }*/
}
