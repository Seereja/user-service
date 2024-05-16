package com.aston.frontendpracticeservice.utils.entity;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.UUID;

@UtilityClass
public class EntityGeneratorConstant {
    public static final UUID UUID_VALUE = UUID.fromString("7261f898-f3a5-40b6-8b31-cac81866b78e");
    public static final UUID UUID_REQUISITES_VALUE = UUID.fromString("19b2f2b1-118b-4960-89bb-40a60cc89a8a");
    public static final String FIRST_NAME = "Name";
    public static final String LAST_NAME = "Surname";
    public static final LocalDate BIRTH_DATE = LocalDate.of(1990, 1, 1);
    public static final String INN = "1234567890";
    public static final String PASSPORT_NUMBER = "12345678";
    public static final String LOGIN = "login1";
    public static final String PASSWORD = "P@ssword123!";
    public static final String SNILS = "123-456-789 12";
    public static final String SNILS_FOR_TEST_LOGIN = "123-468-635 32";
    public static final String SETTLEMENT_ACCOUNT_EXAMPLE = "12345678901234567890";
    public static final String BIK_EXAMPLE = "044525225";
    public static final String CORRESPONDENT_ACCOUNT_EXAMPLE = "30101810400000000225";
    public static final String KPP_EXAMPLE = "771501001";
    public static final String KBK_EXAMPLE = "03531000000000000130";
    public static final String URL_VALID = "/api/v1/users/";
    public static final String URL_CREATION_VALID = "/api/v1/users/creation";

    public static final String LOGIN_FOR_ADD_USER = "login12";
    public static final String PASSPORT_NUMBER_FOR_ADD_USER = "12345798";
    public static final String SNILS_FOR_ADD_USER = "123-907-635 32";
    public static final String INN_FOR_ADD_USER = "7123567891";

}
