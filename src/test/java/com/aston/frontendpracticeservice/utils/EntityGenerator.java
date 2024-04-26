package com.aston.frontendpracticeservice.utils;

import com.aston.frontendpracticeservice.domain.entity.User;

import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.BIRTH_DATE;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.FIRST_NAME;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.INN;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.LAST_NAME;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.LOGIN;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.PASSPORT_NUMBER;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.PASSWORD;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.SNILS;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.UUID_VALUE;

public class EntityGenerator {

    public static User findUserByLogin() {
        User user = new User();
        user.setId(UUID_VALUE);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setInn(INN);
        user.setLogin(LOGIN);
        user.setPassword(PASSWORD);
        user.setSnils(SNILS);
        user.setPassportNumber(PASSPORT_NUMBER);
        user.setBirthDate(BIRTH_DATE);
        return user;
    }

}
