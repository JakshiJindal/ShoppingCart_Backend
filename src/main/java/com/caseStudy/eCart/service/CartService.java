package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.orderHistory;
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
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    public List<orderHistory> showHistory(Long user_id,Principal principal)
    {
        users user=userRepository.findByUserid(user_id);
        return orderHistoryRepository.findAllByUser(user);
    }
    public cart addProducts(Long userid, Long productid) {
        products product = productRepository.findByPid(productid);
        users user = userRepository.findByUserid(userid);
        if (cartRepository.findByUserAndItems(user, product).isPresent()) {
            cart car = cartRepository.findByUserAndItems(user, product).get();
            car.setQuantity(car.getQuantity() + 1);
car.setTotal(car.getQuantity()*product.getPrice());

            cartRepository.save(car);

        } else {
            cart c = new cart();
            c.setUser(user);
            c.setItems(product);
            c.setQuantity(1);
c.setTotal(product.getPrice());

            cartRepository.save(c);

        }
        return  cartRepository.findByUserAndItems(user, product).get();
    }

 /*public String addtocart(Long userid,Long productid)
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
   }*/

    public List<cart> showcart(Long productid, Principal principal) {
        users user = userRepository.findByUsername(principal.getName()).get();
        return cartRepository.findByUserAndItems_Active(user,1);
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
     users user = userRepository.findByUserid(userId);
     double p;
     double total=0;
     List<cart> cartItems = cartRepository.findAllByUser(user);
     for(cart car:cartItems)
     {
         orderHistory order=new orderHistory();
         order.setItems(car.getItems());
         order.setUser(car.getUser());
          p=car.getItems().getPrice();
         order.setQuantity(car.getQuantity());
         total=total+car.getQuantity()*p;
         order.setPrice((int) (car.getQuantity()*p));
         order.setDate();
         orderHistoryRepository.save(order);
     }
     clearcart(userId,principal);
     return total;
    }

public Optional<cart> removeCart(Long userId, Long productid){
    products product = productRepository.findByPid(productid);
    users user = userRepository.findByUserid(userId);
            cart car = cartRepository.findByUserAndItems(user, product).get();
    cartRepository.delete(car);
    return  cartRepository.findByUserAndItems(user, product);
}

    public Optional<cart> removeToproduct(Long userId, Long productid) {
        products product = productRepository.findByPid(productid);
        users user = userRepository.findByUserid(userId);
            if (cartRepository.findByUserAndItems(user, product).get().getQuantity() <= 1) {
                cart car = cartRepository.findByUserAndItems(user, product).get();
                cartRepository.delete(car);
            } else {
                cart car = cartRepository.findByUserAndItems(user, product).get();

                car.setQuantity(car.getQuantity() - 1);
                cartRepository.save(car);
                //fixedCartRepository.save(fixedcart);
            }

        return  cartRepository.findByUserAndItems(user, product);
    }
    public String decreaseQuantity(Long productid, Principal principal) {
        products product = productRepository.findByPid(productid);

        users user = userRepository.findByUsername(principal.getName()).get();
        cart car = cartRepository.findByUserAndItems(user, product).get();
        if (car.getQuantity() == 1) {
            return "quantity canot be decreased further";
        } else {
            car.setQuantity(car.getQuantity() - 1);
            cartRepository.save(car);
            return "quantity decreased";
        }
    }

    public double calPrice(Long userId, Principal principal) {
        users user = userRepository.findByUserid(userId);
        List<cart> cartItems = cartRepository.findAllByUser(user);
        double q=0;
        for(cart car: cartItems) {
            q=q+car.getTotal();
        }
        return q;
    }
}

