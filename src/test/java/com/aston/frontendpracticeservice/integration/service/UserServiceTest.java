package com.aston.frontendpracticeservice.integration.service;

import com.aston.frontendpracticeservice.annotation.TestContainerizedSpringBootTest;
import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.exception.UserNotFoundException;
import com.aston.frontendpracticeservice.service.UserService;
import com.aston.frontendpracticeservice.utils.EntityGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static com.aston.frontendpracticeservice.utils.EntityGeneratorConstant.LOGIN;
import static com.aston.frontendpracticeservice.utils.UserServiceTestConstant.INVALID_LOGIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestContainerizedSpringBootTest
@Sql({
        "classpath:sql/data.sql"
})
class UserServiceTest {

    @Autowired
    private UserService userService;

    private final User TEST_USER = EntityGenerator.findUserByLogin();

    @Test
    @DisplayName("Integration test UserService: find user by login. Should be status OK")
    void testShouldReturnUser() {
        User result = userService.findByLogin(LOGIN);

        assertNotNull(result);
        assertEquals(TEST_USER, result);

    }

    @Test
    @DisplayName("Integration test UserService: find user by invalid login. Should be not found")
    void testShouldReturnNotfoundException() {
        assertThrows(UserNotFoundException.class, () -> userService.findByLogin(INVALID_LOGIN));
    }


}
