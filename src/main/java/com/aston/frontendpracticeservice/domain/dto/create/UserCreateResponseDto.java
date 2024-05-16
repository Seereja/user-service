package com.aston.frontendpracticeservice.domain.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.UUID;

public record UserCreateResponseDto(

        UUID id,

        String firstName,

        String lastName,

        @JsonFormat(pattern = "yyyy-MM-dd")
        @JsonSerialize(using = LocalDateSerializer.class)
        LocalDate birthDate,

        String passportNumber,

        String login,

        String password,

        String snils) {
}
