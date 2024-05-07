package com.aston.frontendpracticeservice.integration.controller;

import com.aston.frontendpracticeservice.annotation.TestContainerizedSpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static com.aston.frontendpracticeservice.utils.EntityGenerator.USER_INFO_DTO;
import static com.aston.frontendpracticeservice.utils.EntityGenerator.generateUser;
import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.URL_VALID;
import static com.aston.frontendpracticeservice.utils.UserServiceTestConstant.INVALID_UUID;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestContainerizedSpringBootTest
@Sql({
        "classpath:sql/dataController.sql"
})
class UserControllerTest extends AbstractIT {

    @Autowired
    MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

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

}
