package com.aston.frontendpracticeservice.repository;

import com.aston.frontendpracticeservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByLogin(String login);

}
