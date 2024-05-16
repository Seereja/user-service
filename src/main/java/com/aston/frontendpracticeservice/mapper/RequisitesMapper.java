package com.aston.frontendpracticeservice.mapper;


import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateRequestDto;
import com.aston.frontendpracticeservice.domain.dto.create.RequisitesCreateRequestDto;
import com.aston.frontendpracticeservice.domain.dto.create.RequisitesCreateResponseDto;
import com.aston.frontendpracticeservice.domain.entity.Requisites;
import com.aston.frontendpracticeservice.domain.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(
        componentModel = SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = IGNORE)
public interface RequisitesMapper {

    @Named("toRequisites")
    @Mapping(target = "settlementAccount", source = "requisitesCreateRequestDto.settlementAccount")
    @Mapping(target = "kpp", source = "requisitesCreateRequestDto.kpp")
    @Mapping(target = "kbk", source = "requisitesCreateRequestDto.kbk")
    @Mapping(target = "inn", source = "requisitesCreateRequestDto.inn")
    @Mapping(target = "correspondentAccount", source = "requisitesCreateRequestDto.correspondentAccount")
    @Mapping(target = "bik", source = "requisitesCreateRequestDto.bik")
    Requisites toRequisites(RequisitesCreateRequestDto requisitesCreateRequestDto);

    @AfterMapping
    default void setRequisites(@MappingTarget User user, PersonalInformationCreateRequestDto personalInformationCreateRequestDto) {
        Requisites requisites = toRequisites(personalInformationCreateRequestDto.requisitesCreateRequestDto());
        user.setRequisites(requisites);
        requisites.setUser(user);
    }

    RequisitesCreateResponseDto toRequisitesCreateResponseDto(Requisites requisites);


}
