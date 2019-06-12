package com.pluralsight.mvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluralsight.mvc.entity.RegisteredUser;

@Repository
public interface AppUserRepository extends JpaRepository<RegisteredUser, Long> {

	Optional<RegisteredUser> findByUsername(String username);

}
