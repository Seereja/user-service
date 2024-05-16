package com.aston.frontendpracticeservice.domain.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Добавление информации о юзере")
public record PersonalInformationCreateRequestDto(

        @Valid
        @NotNull
        @Schema(description = "DTO для добавления персональной информации юзера")
        UserCreateRequestDto userCreateRequestDto,

        @Valid
        @NotNull
        @Schema(description = "DTO для добавления реквизитов юзера")
        RequisitesCreateRequestDto requisitesCreateRequestDto
) {
}
