package com.aston.frontendpracticeservice.annotation;

import com.aston.frontendpracticeservice.FrontendPracticeServiceApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("test")
@Testcontainers
@SpringBootTest(classes = FrontendPracticeServiceApplication.class)
public @interface TestContainerizedSpringBootTest {
}
