package com.aston.frontendpracticeservice.facade;

import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateRequestDto;
import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateResponseDto;
import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import com.aston.frontendpracticeservice.kafka.event.InfoEvent;
import com.aston.frontendpracticeservice.kafka.event.RegistrationEvent;
import com.aston.frontendpracticeservice.kafka.producer.KafkaProducerService;
import com.aston.frontendpracticeservice.mapper.UserMapper;
import com.aston.frontendpracticeservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Component
@RequiredArgsConstructor
@Slf4j
public class UserFacade {


    private final UserMapper userMapper;

    private final UserService userService;

    private final KafkaProducerService kafkaProducerService;

    public PersonalInformationCreateResponseDto addUser(PersonalInformationCreateRequestDto personalInformationCreateRequestDto) {
        log.info("Add new user with data: {}", personalInformationCreateRequestDto);
        User userBeforeSave = userMapper.toUser(personalInformationCreateRequestDto);
        User userAfterSave = userService.addUser(userBeforeSave);
        RegistrationEvent registrationEvent = userMapper.toUserRegistrationEvent(userAfterSave);
        kafkaProducerService.sendUserRegistration(registrationEvent);
        return userMapper.toPersonalInformationCreateResponseDto(userAfterSave);
    }

    @Transactional
    public UserInfoDto getUserInfo(UUID id) {
        log.info("get  user info with data: {}", id);
        UserInfoDto getUserInfo = userService.findUserInfoById(id);
        InfoEvent userInfoEvent = userMapper.toUserGetInfoEvent(getUserInfo);
        kafkaProducerService.sendGetUserInfo(userInfoEvent);
        return getUserInfo;
    }


}
