package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.products;
import com.caseStudy.eCart.models.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<cart, Long> {
List<cart> findByUserAndItems_Active(users userid,int active);
List<cart> findAllByUser(users user);
Optional<cart> findByUserAndItems(users userid,products productid);
    void deleteByCid(Long aLong);
}
