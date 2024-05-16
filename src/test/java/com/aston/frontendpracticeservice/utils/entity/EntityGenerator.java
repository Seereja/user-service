package com.aston.frontendpracticeservice.utils.entity;

import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateRequestDto;
import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateResponseDto;
import com.aston.frontendpracticeservice.domain.dto.create.RequisitesCreateRequestDto;
import com.aston.frontendpracticeservice.domain.dto.create.RequisitesCreateResponseDto;
import com.aston.frontendpracticeservice.domain.dto.create.UserCreateRequestDto;
import com.aston.frontendpracticeservice.domain.dto.create.UserCreateResponseDto;
import com.aston.frontendpracticeservice.domain.entity.Requisites;
import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import lombok.experimental.UtilityClass;


import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.BIK_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.BIRTH_DATE;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.CORRESPONDENT_ACCOUNT_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.FIRST_NAME;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.INN;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.INN_FOR_ADD_USER;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.KBK_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.KPP_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.LAST_NAME;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.LOGIN;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.LOGIN_FOR_ADD_USER;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.PASSPORT_NUMBER;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.PASSPORT_NUMBER_FOR_ADD_USER;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.PASSWORD;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.SETTLEMENT_ACCOUNT_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.SNILS;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.SNILS_FOR_ADD_USER;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.SNILS_FOR_TEST_LOGIN;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.UUID_REQUISITES_VALUE;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.UUID_VALUE;

@UtilityClass
public class EntityGenerator {

    public static User findUserByLogin() {
        User user = new User();
        user.setId(UUID_VALUE);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setLogin(LOGIN);
        user.setPassword(PASSWORD);
        user.setSnils(SNILS_FOR_TEST_LOGIN);
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

    public static PersonalInformationCreateRequestDto createRequestDto() {
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(
                FIRST_NAME,
                LAST_NAME,
                BIRTH_DATE,
                PASSPORT_NUMBER_FOR_ADD_USER,
                LOGIN_FOR_ADD_USER,
                PASSWORD,
                SNILS_FOR_ADD_USER
        );
        RequisitesCreateRequestDto requisitesCreateRequestDto = new RequisitesCreateRequestDto(
                SETTLEMENT_ACCOUNT_EXAMPLE,
                BIK_EXAMPLE,
                CORRESPONDENT_ACCOUNT_EXAMPLE,
                INN_FOR_ADD_USER,
                KPP_EXAMPLE,
                KBK_EXAMPLE
        );
        return new PersonalInformationCreateRequestDto(userCreateRequestDto, requisitesCreateRequestDto);
    }

    public static PersonalInformationCreateRequestDto createRequestDtoWithExistLogin() {
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(
                FIRST_NAME,
                LAST_NAME,
                BIRTH_DATE,
                PASSPORT_NUMBER,
                LOGIN,
                PASSWORD,
                SNILS
        );
        RequisitesCreateRequestDto requisitesCreateRequestDto = new RequisitesCreateRequestDto(
                SETTLEMENT_ACCOUNT_EXAMPLE,
                BIK_EXAMPLE,
                CORRESPONDENT_ACCOUNT_EXAMPLE,
                INN_FOR_ADD_USER,
                KPP_EXAMPLE,
                KBK_EXAMPLE
        );
        return new PersonalInformationCreateRequestDto(userCreateRequestDto, requisitesCreateRequestDto);
    }

    public static PersonalInformationCreateRequestDto createRequestDtoWithExistInn() {
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(
                FIRST_NAME,
                LAST_NAME,
                BIRTH_DATE,
                PASSPORT_NUMBER_FOR_ADD_USER,
                LOGIN_FOR_ADD_USER,
                PASSWORD,
                SNILS_FOR_ADD_USER
        );
        RequisitesCreateRequestDto requisitesCreateRequestDto = new RequisitesCreateRequestDto(
                SETTLEMENT_ACCOUNT_EXAMPLE,
                BIK_EXAMPLE,
                CORRESPONDENT_ACCOUNT_EXAMPLE,
                INN,
                KPP_EXAMPLE,
                KBK_EXAMPLE
        );
        return new PersonalInformationCreateRequestDto(userCreateRequestDto, requisitesCreateRequestDto);
    }


    public static PersonalInformationCreateRequestDto createRequestDtoWithExistSnils() {
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(
                FIRST_NAME,
                LAST_NAME,
                BIRTH_DATE,
                PASSPORT_NUMBER_FOR_ADD_USER,
                LOGIN_FOR_ADD_USER,
                PASSWORD,
                SNILS
        );
        RequisitesCreateRequestDto requisitesCreateRequestDto = new RequisitesCreateRequestDto(
                SETTLEMENT_ACCOUNT_EXAMPLE,
                BIK_EXAMPLE,
                CORRESPONDENT_ACCOUNT_EXAMPLE,
                INN,
                KPP_EXAMPLE,
                KBK_EXAMPLE
        );
        return new PersonalInformationCreateRequestDto(userCreateRequestDto, requisitesCreateRequestDto);
    }

    public static PersonalInformationCreateRequestDto createRequestDtoWithExistPassportNumber() {
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(
                FIRST_NAME,
                LAST_NAME,
                BIRTH_DATE,
                PASSPORT_NUMBER,
                LOGIN_FOR_ADD_USER,
                PASSWORD,
                SNILS_FOR_ADD_USER
        );
        RequisitesCreateRequestDto requisitesCreateRequestDto = new RequisitesCreateRequestDto(
                SETTLEMENT_ACCOUNT_EXAMPLE,
                BIK_EXAMPLE,
                CORRESPONDENT_ACCOUNT_EXAMPLE,
                INN_FOR_ADD_USER,
                KPP_EXAMPLE,
                KBK_EXAMPLE
        );
        return new PersonalInformationCreateRequestDto(userCreateRequestDto, requisitesCreateRequestDto);
    }

    public static PersonalInformationCreateRequestDto createRequestDtoWithExist() {
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto(
                FIRST_NAME,
                LAST_NAME,
                BIRTH_DATE,
                PASSPORT_NUMBER_FOR_ADD_USER,
                LOGIN_FOR_ADD_USER,
                PASSWORD,
                SNILS
        );
        RequisitesCreateRequestDto requisitesCreateRequestDto = new RequisitesCreateRequestDto(
                SETTLEMENT_ACCOUNT_EXAMPLE,
                BIK_EXAMPLE,
                CORRESPONDENT_ACCOUNT_EXAMPLE,
                INN,
                KPP_EXAMPLE,
                KBK_EXAMPLE
        );
        return new PersonalInformationCreateRequestDto(userCreateRequestDto, requisitesCreateRequestDto);
    }


    public static PersonalInformationCreateResponseDto createResponseDto() {
        UserCreateResponseDto userCreateResponseDto = new UserCreateResponseDto(
                UUID_VALUE,
                FIRST_NAME,
                LAST_NAME,
                BIRTH_DATE,
                PASSPORT_NUMBER_FOR_ADD_USER,
                LOGIN_FOR_ADD_USER,
                PASSWORD,
                SNILS
        );
        RequisitesCreateResponseDto requisitesCreateResponseDto = new RequisitesCreateResponseDto(
                UUID_REQUISITES_VALUE,
                SETTLEMENT_ACCOUNT_EXAMPLE,
                BIK_EXAMPLE,
                CORRESPONDENT_ACCOUNT_EXAMPLE,
                INN_FOR_ADD_USER,
                KPP_EXAMPLE,
                KBK_EXAMPLE
        );
        return new PersonalInformationCreateResponseDto(requisitesCreateResponseDto, userCreateResponseDto);
    }


    public static final UserInfoDto USER_INFO_DTO
            = new UserInfoDto(FIRST_NAME, SETTLEMENT_ACCOUNT_EXAMPLE, KBK_EXAMPLE);
}
