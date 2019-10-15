package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.orderHistory;
import com.caseStudy.eCart.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<orderHistory,Long> {

    List<orderHistory> findAllByUser(users user);
}
