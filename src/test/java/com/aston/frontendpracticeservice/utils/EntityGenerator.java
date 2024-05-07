package com.aston.frontendpracticeservice.utils;

import com.aston.frontendpracticeservice.domain.entity.Requisites;
import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import lombok.experimental.UtilityClass;


import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.BIK_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.BIRTH_DATE;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.CORRESPONDENT_ACCOUNT_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.FIRST_NAME;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.INN;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.KBK_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.KPP_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.LAST_NAME;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.LOGIN;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.PASSPORT_NUMBER;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.PASSWORD;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.SETTLEMENT_ACCOUNT_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.SNILS;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.UUID_REQUISITES_VALUE;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.UUID_VALUE;

@UtilityClass
public class EntityGenerator {

    public static User findUserByLogin() {
        User user = new User();
        user.setId(UUID_VALUE);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setLogin(LOGIN);
        user.setPassword(PASSWORD);
        user.setSnils(SNILS);
        user.setPassportNumber(PASSPORT_NUMBER);
        user.setBirthDate(BIRTH_DATE);
        return user;
    }


    public static User generateUser() {
        return User.builder()
                .id(UUID_VALUE)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .login(LOGIN)
                .password(PASSWORD)
                .snils(SNILS)
                .passportNumber(PASSPORT_NUMBER)
                .birthDate(BIRTH_DATE)
                .requisites(generateRequisites())
                .build();
    }

    public static Requisites generateRequisites() {
        return Requisites
                .builder()
                .id(UUID_REQUISITES_VALUE)
                .kpp(KPP_EXAMPLE)
                .kbk(KBK_EXAMPLE)
                .correspondentAccount(CORRESPONDENT_ACCOUNT_EXAMPLE)
                .settlementAccount(SETTLEMENT_ACCOUNT_EXAMPLE)
                .bik(BIK_EXAMPLE)
                .inn(INN).build();
    }

    public static final UserInfoDto USER_INFO_DTO
            = new UserInfoDto(FIRST_NAME, SETTLEMENT_ACCOUNT_EXAMPLE, KBK_EXAMPLE);
}
