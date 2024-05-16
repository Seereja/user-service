package com.aston.frontendpracticeservice.domain.dto.create;

public record PersonalInformationCreateResponseDto(

        RequisitesCreateResponseDto requisitesCreateResponseDto,
        UserCreateResponseDto userCreateResponseDto) {
}
