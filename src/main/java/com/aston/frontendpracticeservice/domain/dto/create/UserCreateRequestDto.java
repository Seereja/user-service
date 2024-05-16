package com.aston.frontendpracticeservice.domain.dto.create;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.DATE_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.FIRST_NAME_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.LAST_NAME_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.LOGIN_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.NUMBER_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.PASSWORD_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.SNILS_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.LOGIN_VALID;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.PASSPORT_VALID;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.PASSWORD_VALID;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.PATTERN_VALID_FIRST_NAME;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.PATTERN_VALID_LAST_NAME;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.SNILS_VALID;

@Schema(description = "Добавление персональной информации о юзере")
public record UserCreateRequestDto(

        @NotNull
        @Pattern(regexp = PATTERN_VALID_FIRST_NAME,
                message = FIRST_NAME_VALID_MESSAGE)
        @Schema(description = "Имя", example = "Иван")
        String firstName,

        @NotBlank
        @Pattern(regexp = PATTERN_VALID_LAST_NAME,
                message = LAST_NAME_VALID_MESSAGE)
        String lastName,

        @NotNull(message = DATE_VALID_MESSAGE)

        @JsonFormat(pattern = "yyyy-MM-dd")
        @JsonSerialize(using = LocalDateSerializer.class)
        @Schema(description = "Дата рождения клиента", example = "2000-12-31")
        LocalDate birthDate,

        @NotNull
        @Pattern(regexp = PASSPORT_VALID,
                message = NUMBER_VALID_MESSAGE)
        @Schema(description = "Номер паспорта клиента", example = "12345678")
        String passportNumber,

        @NotBlank
        @Pattern(regexp = LOGIN_VALID,
                message = LOGIN_VALID_MESSAGE)
        @Schema(description = "Логин", example = "safasf@a3q")
        String login,

        @NotBlank
        @Pattern(regexp = PASSWORD_VALID,
                message = PASSWORD_VALID_MESSAGE)
        @Schema(description = "пароль", example = "Safasf@a3q")
        String password,

        @NotBlank
        @Pattern(regexp = SNILS_VALID,
                message = SNILS_VALID_MESSAGE)
        @Schema(description = "снилс", example = "123-456-789 01")
        String snils
) {
}
