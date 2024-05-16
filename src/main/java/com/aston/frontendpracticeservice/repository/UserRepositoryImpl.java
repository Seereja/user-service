package com.aston.frontendpracticeservice.repository;

import com.aston.frontendpracticeservice.domain.entity.Requisites;
import com.aston.frontendpracticeservice.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl {

    private final UserJpaRepository userJpaRepository;

    public List<User> findByLoginOrPassportNumberOrInn
            (String login, String passportNumber, String snils, Requisites requisites) {
        return userJpaRepository.findAll(Specification
                .where(UserSpecifications.filterByLogin(login))
                .or(UserSpecifications.filterByPassportNumber(passportNumber))
                .or(UserSpecifications.filterBySnils(snils))
                .or(UserSpecifications.filterByInn(requisites)));
    }
}
