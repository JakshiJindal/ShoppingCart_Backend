package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Long> {

}
