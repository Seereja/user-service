package com.aston.frontendpracticeservice.utils.exceptions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MessageExceptionConstant {

    public static final String LOGIN_EXIST_EXCEPTION = "Клиент с таким логином уже есть в системе";

    public static final String INN_EXIST_EXCEPTION = "Клиент с таким инн уже есть в системе";

    public static final String PASSPORT_NUMBER_EXIST_EXCEPTION = "Клиент с таким паспортом уже есть в системе";

    public static final String SNILS_EXIST_EXCEPTION = "Клиент с таким снилсом уже есть в системе";
}
