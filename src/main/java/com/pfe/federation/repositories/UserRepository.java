package com.pfe.federation.repositories;

import com.pfe.federation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    void deleteByEmail(String email);
    Optional<User> findByName(String name);

    Optional<User> findById(Integer userId);
}
