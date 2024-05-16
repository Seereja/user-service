package com.aston.frontendpracticeservice.mapper;


import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateRequestDto;

import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateResponseDto;
import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.kafka.event.InfoEvent;
import com.aston.frontendpracticeservice.kafka.event.RegistrationEvent;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = RequisitesMapper.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = IGNORE)
public interface UserMapper {

    @Mapping(target = "firstName", source = "userCreateRequestDto.firstName")
    @Mapping(target = "lastName", source = "userCreateRequestDto.lastName")
    @Mapping(target = "birthDate", source = "userCreateRequestDto.birthDate")
    @Mapping(target = "passportNumber", source = "userCreateRequestDto.passportNumber")
    @Mapping(target = "login", source = "userCreateRequestDto.login")
    @Mapping(target = "password", source = "userCreateRequestDto.password")
    @Mapping(target = "snils", source = "userCreateRequestDto.snils")
    @Mapping(target = "requisites", source = "requisitesCreateRequestDto", qualifiedByName = "toRequisites")
    User toUser(PersonalInformationCreateRequestDto personalInformationCreateRequestDto);


    @Mapping(target = "userCreateResponseDto", source = "user")
    @Mapping(target = "requisitesCreateResponseDto", source = "requisites")
    PersonalInformationCreateResponseDto toPersonalInformationCreateResponseDto(User user);


    @Mapping(target = "id", expression = "java(user.getId().toString())")
    @Mapping(target = "fullName", source = ".", qualifiedByName = "mapFullName")
    RegistrationEvent toUserRegistrationEvent(User user);

    @Named("mapFullName")
    default String mapFullName(User user) {
        if (user == null) {
            return null;
        }
        return Stream
                .of(user.getLastName(), user.getFirstName())
                .filter(Objects::nonNull)
                .collect(Collectors.joining(" "));
    }

    InfoEvent toUserGetInfoEvent(UserInfoDto user);


}
