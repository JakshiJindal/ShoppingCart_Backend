package com.caseStudy.eCart.controller;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.orderHistory;
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
@RequestMapping("/apii")
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private CurrentUserService currentUserService;
    @Autowired
    public CartController(CartService cartService, CurrentUserService currentUserService) {
        this.cartService = cartService;
        this.currentUserService = currentUserService;
    }

    @GetMapping("/orderss")
    public List<orderHistory>  getAllDetails(Principal principal)
    {
        return cartService.showHistory(currentUserService.getUserId(principal),principal);
    }
    @RequestMapping(value = "/addtocart/recieve/{productid}", method = RequestMethod.POST)
    @ResponseBody
    public cart addtocart(@PathVariable Long productid, Principal principal) {
        return cartService.addProducts(currentUserService.getUserId(principal), productid);
    }

    @RequestMapping(value = "/showcart/recieve", method = RequestMethod.GET)
    @ResponseBody
    public List<cart> showcart(Principal principal)
    {
        return cartService.showcart(currentUserService.getUserId(principal),principal);
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
    @RequestMapping(value="/removeToProduct/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public Optional<cart> removetoProduct( @PathVariable Long productid,Principal principal)
    {
        return cartService.removeToproduct(currentUserService.getUserId(principal),productid);
    }
    @RequestMapping(value="/removeCart/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public Optional<cart> removetoCart( @PathVariable Long productid,Principal principal)
    {
        return cartService.removeCart(currentUserService.getUserId(principal),productid);
    }
    @RequestMapping(value="/decreaseQuantity/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public String decreaseQuantity(Principal principal,@PathVariable Long productid)
    {
        return cartService.decreaseQuantity(productid,principal);
    }
    @RequestMapping(value="/price",method= RequestMethod.GET)
    @ResponseBody
    public double price(Principal principal)
    {
        return cartService.calPrice(currentUserService.getUserId(principal),principal);
    }
}
