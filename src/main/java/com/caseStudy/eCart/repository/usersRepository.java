package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<users, Long> {
   @Override
   List<users> findAll();
    Optional<users> findByUsername(String username);
    users findByUserid(Long id);

    Optional<users> findByRole(String role);
}
