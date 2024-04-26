package com.aston.frontendpracticeservice.repository;

import com.aston.frontendpracticeservice.annotation.TestContainerizedSpringBootTest;
import com.aston.frontendpracticeservice.domain.entity.User;
import com.aston.frontendpracticeservice.exception.UserNotFoundException;
import com.aston.frontendpracticeservice.service.UserService;
import com.aston.frontendpracticeservice.utils.EntityGenerator;
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
    void test_should_return_User() {
        User result = userService.findByLogin(LOGIN);

        assertNotNull(result);
        assertEquals(TEST_USER, result);

    }

    @Test
    void test_should_return_NotfoundException() {
        assertThrows(UserNotFoundException.class, () -> userService.findByLogin(INVALID_LOGIN));
    }


}
