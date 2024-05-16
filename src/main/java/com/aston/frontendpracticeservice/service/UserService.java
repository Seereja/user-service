package com.aston.frontendpracticeservice.service;

import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.domain.exceptions.UserAlreadyExistsException;
import com.aston.frontendpracticeservice.exception.UserNotFoundException;
import com.aston.frontendpracticeservice.repository.UserJpaRepository;
import com.aston.frontendpracticeservice.repository.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.aston.frontendpracticeservice.service.utils.MessageExceptionConstants.USER_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final UserRepositoryImpl userRepository;

    public User findByLogin(String login) {
        return userJpaRepository.findUserByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

    public UserInfoDto findUserInfoById(UUID id) {
        return userJpaRepository.findUserInfoById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }


    public User addUser(User user) {
        log.info("Add new user {}", user);

        List<User> existingUser = userRepository.findByLoginOrPassportNumberOrInn(
                user.getLogin(),
                user.getPassportNumber(),
                user.getSnils(),
                user.getRequisites()
        );
        if (existingUser.isEmpty()) {
            return userJpaRepository.save(user);
        } else if (Objects.equals(user.getLogin(), existingUser.get(0).getLogin())) {
            throw new UserAlreadyExistsException("Клиент с таким логином уже есть в системе");
        } else if (Objects.equals(user.getSnils(), existingUser.get(0).getSnils())) {
            throw new UserAlreadyExistsException("Клиент с таким снилсом уже есть в системе");
        } else if (Objects.equals(user.getPassportNumber(), existingUser.get(0).getPassportNumber())) {
            throw new UserAlreadyExistsException("Клиент с таким паспортом уже есть в системе");
        } else {
            throw new UserAlreadyExistsException("Клиент с таким инн уже есть в системе");
        }

    }

}