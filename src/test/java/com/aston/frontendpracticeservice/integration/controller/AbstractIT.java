package com.aston.frontendpracticeservice.integration.controller;

import com.aston.frontendpracticeservice.annotation.TestContainerizedSpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@TestContainerizedSpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractIT {


    /**
     * Метод создания RequestBuilder для GET-запроса.
     *
     * @param url URL GET-запроса
     * @return MockHttpServletRequestBuilder для дальнейшего построения запроса
     */

    protected MockHttpServletRequestBuilder getRequest(String url) {
        return MockMvcRequestBuilders
                .request(HttpMethod.GET, url)
                .contentType(MediaType.APPLICATION_JSON);
    }

    /**
     * Метод создания RequestBuilder для POST-запроса.
     *
     * @param url URL POST-запроса
     * @return MockHttpServletRequestBuilder для дальнейшего построения запроса
     */
    protected MockHttpServletRequestBuilder postRequest(String url, String body) {
        return MockMvcRequestBuilders
                .request(HttpMethod.POST, url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body);
    }

}
