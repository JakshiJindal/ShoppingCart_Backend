package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<products, Long> {
    @Override
    List<products> findAll();

    List<products> findAllByCategory(String p);

    List<products> findAllByPrice(Double p);

    List<products> findAllByPriceBetween(Double p,Double p2);

}
