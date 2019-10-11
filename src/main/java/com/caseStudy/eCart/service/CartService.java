package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.products;
import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    productRepository productRepository;
    @Autowired
    UsersRepository userRepository;
    @Autowired
    CartRepository cartRepository;
/*    @Autowired
    private OrderHistoryRepository orderHistoryRepository;*/

    public cart addProducts(Long userid, Long productid) {
        products product = productRepository.findByPid(productid);
        users user = userRepository.findByUserid(userid);
        if (cartRepository.findByUserAndItems(user, product).isPresent()) {
            cart car = cartRepository.findByUserAndItems(user, product).get();
            // fixedCart fixedcart=fixedCartRepository.findByRefid().intvalue();

            car.setQuantity(car.getQuantity() + 1);
            // fixedcart.setQuantity(fixedcart.getQuantity()+1);
            cartRepository.saveAndFlush(car);
            //  fixedCartRepository.save(fixedcart);
        } else {
            cart c = new cart(product, user, 1);
            //  fixedCart fc=new fixedCart(item,user,1);
            cartRepository.save(c);
            // fixedCartRepository.save(fc);
        }
        return  cartRepository.findByUserAndItems(user, product).get();
    }

 public String addtocart(Long userid,Long productid)
     {
         products products= productRepository.findByPid(productid);
         users user=userRepository.findByUserid(userid);
         if(cartRepository.findByUserAndItems(user,products).isPresent()){
             return "this item is already in your cart";
         }
         else{
             cart cart1=new cart(products,user,1);
             cartRepository.save(cart1);
             return "Sucessfully added";
       }
   }

    public Optional<cart> showcart(Long productid, Principal principal) {
        users user = userRepository.findByUsername(principal.getName()).get();
        products product = productRepository.findByPid(productid);
        return cartRepository.findByUserAndItems(user,product);
    }

  public String clearcart(Long userid,Principal principal) {
        users user = userRepository.findByUserid(userid);
        List<cart> cartItems = cartRepository.findAllByUser(user);
        for (cart cart1 : cartItems) {
            cartRepository.deleteById(cart1.getId());
        }
        return "cart cleared";
    }
 public double checkout(Long userId,Principal principal) {
return 2;
    }



    public String removecart(Long userId, Long productid) {
        products product = productRepository.findByPid(productid);
        users user = userRepository.findByUserid(userId);
        if (cartRepository.findByUserAndItems(user, product).get().getQuantity() <= 1) {
                   cart car2 = cartRepository.findByUserAndItems(user, product).get();
                   cartRepository.delete(car2);
        } else  {
             cart car = cartRepository.findByUserAndItems(user, product).get();

             car.setQuantity(car.getQuantity()-1);
             cartRepository.save(car);
            //fixedCartRepository.save(fixedcart);
        }
        return "removed";
    }
 /*   public String decreaseQuantity(Long productid, Principal principal)
    {
        products product = productRepository.findByPid(productid);

        users user = userRepository.findByUsername(principal.getName()).get();
        cart car = cartRepository.findByUserAndItems(user, product).get();
        if (car.getQuantity() == 1) {
           return "quantity canot be decreased further";
        } else {
           car.setQuantity(car.getQuantity()-1);
           cartRepository.save(car);
           return "quantity decreased";
        }*/
    }

