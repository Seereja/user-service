package com.aston.frontendpracticeservice.repository;

import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByLogin(String login);

    @Query(value = """
            select new com.aston
            .frontendpracticeservice
            .domain
            .response
            .UserInfoDto(u.firstName,r.settlementAccount,r.kbk)
            from Requisites r left join User u on
            u.id=r.id where u.id=:id
            """)
    Optional<UserInfoDto> findUserInfoById(UUID id);
}
