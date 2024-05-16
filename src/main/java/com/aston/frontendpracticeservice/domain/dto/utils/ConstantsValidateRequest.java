package com.aston.frontendpracticeservice.domain.dto.utils;

public class ConstantsValidateRequest {

    public ConstantsValidateRequest() {
    }

    public static final String PATTERN_VALID_FIRST_NAME = "^(?![-' ])(?!.*[-' ]$)[A-Za-zА-Яа-я][-A-Za-zА-Яа-я ']{0,28}$";

    public static final String PATTERN_VALID_LAST_NAME = "^(?![-' ])(?!.*[-' ]$)[A-Za-zА-Яа-я][-A-Za-zА-Яа-я ']{0,28}$";

    public static final String PASSWORD_VALID = "^[A-Za-zА-Яа-я0-9 !\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]{1,20}$";

    public static final String LOGIN_VALID = "^[A-Za-zА-Яа-я0-9 !\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]{1,20}$";

    public static final String PATTERN_VALID_INN = "^\\d{10}$";

    public static final String SNILS_VALID = "\\d{3}-\\d{3}-\\d{3} \\d{2}";

    public static final String SETTLEMENT_ACCOUNT_VALID = "\\d{20}";

    public static final String CORRESPONDENT_ACCOUNT_VALID = "\\d{20}";

    public static final String PASSPORT_VALID = "\\d{8}";

    public static final String BIK_VALID = "\\d{9}";

    public static final String KBK_VALID = "\\d{20}";

    public static final String KPP_VALID = "\\d{9}";


}
