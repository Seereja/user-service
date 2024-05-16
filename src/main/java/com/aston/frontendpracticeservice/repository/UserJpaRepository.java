package com.aston.frontendpracticeservice.repository;

import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import com.aston.frontendpracticeservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

    Optional<User> findUserByLogin(String login);

    @Query(value = """
            select new com
            .aston
            .frontendpracticeservice
            .domain
            .response
            .UserInfoDto(u.firstName,r.settlementAccount,r.kbk)
            from Requisites r
            inner join r.user u
            where u.id = :id
            """)
    Optional<UserInfoDto> findUserInfoById(@Param("id") UUID id);
}
