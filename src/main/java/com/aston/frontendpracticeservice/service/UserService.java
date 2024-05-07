package com.aston.frontendpracticeservice.service;

import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import com.aston.frontendpracticeservice.exception.UserNotFoundException;
import com.aston.frontendpracticeservice.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.aston.frontendpracticeservice.service.utils.MessageExceptionConstants.USER_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public User findByLogin(String login) {
        return userJpaRepository.findUserByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

    public UserInfoDto findUserInfoById(UUID id) {
        return userJpaRepository.findUserInfoById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

}