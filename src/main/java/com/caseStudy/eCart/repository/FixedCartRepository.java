package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedCartRepository  extends JpaRepository<users, Long> {
}
