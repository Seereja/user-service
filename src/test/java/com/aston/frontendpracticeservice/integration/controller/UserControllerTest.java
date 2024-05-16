package com.aston.frontendpracticeservice.integration.controller;

import com.aston.frontendpracticeservice.annotation.TestContainerizedSpringBootTest;
import com.aston.frontendpracticeservice.kafka.producer.KafkaProducerService;
import com.aston.frontendpracticeservice.kafka.util.KafkaAdminClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static com.aston.frontendpracticeservice.utils.entity.EntityGenerator.USER_INFO_DTO;
import static com.aston.frontendpracticeservice.utils.entity.EntityGenerator.createRequestDto;
import static com.aston.frontendpracticeservice.utils.entity.EntityGenerator.createRequestDtoWithExistInn;
import static com.aston.frontendpracticeservice.utils.entity.EntityGenerator.createRequestDtoWithExistLogin;
import static com.aston.frontendpracticeservice.utils.entity.EntityGenerator.createRequestDtoWithExistPassportNumber;
import static com.aston.frontendpracticeservice.utils.entity.EntityGenerator.createRequestDtoWithExistSnils;
import static com.aston.frontendpracticeservice.utils.entity.EntityGenerator.createResponseDto;
import static com.aston.frontendpracticeservice.utils.entity.EntityGenerator.generateUser;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.URL_CREATION_VALID;
import static com.aston.frontendpracticeservice.utils.entity.EntityGeneratorConstant.URL_VALID;
import static com.aston.frontendpracticeservice.utils.exceptions.MessageExceptionConstant.INN_EXIST_EXCEPTION;
import static com.aston.frontendpracticeservice.utils.exceptions.MessageExceptionConstant.LOGIN_EXIST_EXCEPTION;
import static com.aston.frontendpracticeservice.utils.exceptions.MessageExceptionConstant.PASSPORT_NUMBER_EXIST_EXCEPTION;
import static com.aston.frontendpracticeservice.utils.exceptions.MessageExceptionConstant.SNILS_EXIST_EXCEPTION;
import static com.aston.frontendpracticeservice.utils.service.UserServiceTestConstant.INVALID_UUID;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestContainerizedSpringBootTest
@Sql({
        "classpath:sql/dataController.sql"
})
class UserControllerTest extends AbstractIT {

    @MockBean
    KafkaProducerService kafkaProducerService;
    @MockBean
    KafkaAdminClient kafkaAdminClient;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Integration test UserController: find user info by id. Should be status OK")
    void testShouldReturnStatusOk() throws Exception {
        String result = objectMapper.writeValueAsString(USER_INFO_DTO);
        mockMvc.perform(getRequest(URL_VALID + generateUser().getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(result));
    }

    @Test
    @DisplayName("Integration test UserController: find user info by not user UUID. Should be not found")
    void testShouldReturnStatus404() throws Exception {

        mockMvc.perform(getRequest(URL_VALID + UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Integration test UserController: find user info by invalid id. Should be is bad request")
    void testShouldReturnStatus400() throws Exception {

        mockMvc.perform(getRequest(URL_VALID + INVALID_UUID))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Integration test UserController: Should return status 200 and validate response fields")
    void testShouldReturnStatus200() throws Exception {
        var requestDto = createRequestDto();
        var expected = createResponseDto();

        mockMvc.perform(postRequest(URL_CREATION_VALID, objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.requisitesCreateResponseDto.settlementAccount")
                        .value(expected.requisitesCreateResponseDto().settlementAccount()))
                .andExpect(jsonPath("$.requisitesCreateResponseDto.bik")
                        .value(expected.requisitesCreateResponseDto().bik()))
                .andExpect(jsonPath("$.requisitesCreateResponseDto.kbk")
                        .value(expected.requisitesCreateResponseDto().kbk()))
                .andExpect(jsonPath("$.requisitesCreateResponseDto.kpp")
                        .value(expected.requisitesCreateResponseDto().kpp()))
                .andExpect(jsonPath("$.requisitesCreateResponseDto.inn")
                        .value(expected.requisitesCreateResponseDto().inn()))
                .andExpect(jsonPath("$.requisitesCreateResponseDto.correspondentAccount")
                        .value(expected.requisitesCreateResponseDto().correspondentAccount()))
                .andExpect(jsonPath("$.userCreateResponseDto.firstName")
                        .value(expected.userCreateResponseDto().firstName()))
                .andExpect(jsonPath("$.userCreateResponseDto.lastName")
                        .value(expected.userCreateResponseDto().lastName()))
                .andExpect(jsonPath("$.userCreateResponseDto.birthDate")
                        .value(expected.userCreateResponseDto().birthDate().toString())) // Проверка существования поля birthDate
                .andExpect(jsonPath("$.userCreateResponseDto.passportNumber")
                        .value(expected.userCreateResponseDto().passportNumber()))
                .andExpect(jsonPath("$.userCreateResponseDto.login")
                        .value(expected.userCreateResponseDto().login()))
                .andExpect(jsonPath("$.userCreateResponseDto.password")
                        .value(expected.userCreateResponseDto().password()));
    }

    @DisplayName("Should return status 409 for existing login")
    @Test
    void testShouldReturnStatus409ForExistingLogin() throws Exception {
        var requestDto = createRequestDtoWithExistLogin();

        mockMvc.perform(postRequest(URL_CREATION_VALID, objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.errorCode").value(409))
                .andExpect(jsonPath("$.errorMessage").value(LOGIN_EXIST_EXCEPTION));
    }

    @DisplayName("Should return status 409 for existing inn")
    @Test
    void testShouldReturnStatus409ForExistingInn() throws Exception {
        var requestDto = createRequestDtoWithExistInn();

        mockMvc.perform(postRequest(URL_CREATION_VALID, objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.errorCode").value(409))
                .andExpect(jsonPath("$.errorMessage").value(INN_EXIST_EXCEPTION));

    }

    @DisplayName("Should return status 409 for existing snils")
    @Test
    void testShouldReturnStatus409ForExistingSnils() throws Exception {
        var requestDto = createRequestDtoWithExistSnils();


        mockMvc.perform(postRequest(URL_CREATION_VALID, objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.errorCode").value(409))
                .andExpect(jsonPath("$.errorMessage").value(SNILS_EXIST_EXCEPTION));
    }

    @DisplayName("Should return status 409 for existing passportNumber")
    @Test
    void testShouldReturnStatus409ForExistingPassportNumber() throws Exception {
        var requestDto = createRequestDtoWithExistPassportNumber();


        mockMvc.perform(postRequest(URL_CREATION_VALID, objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.errorCode").value(409))
                .andExpect(jsonPath("$.errorMessage").value(PASSPORT_NUMBER_EXIST_EXCEPTION));
    }

}



