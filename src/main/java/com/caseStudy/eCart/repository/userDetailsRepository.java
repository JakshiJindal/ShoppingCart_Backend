package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.userDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userDetailsRepository extends JpaRepository<userDetails, Long> {

}
