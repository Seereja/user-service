package com.aston.frontendpracticeservice.controller;

import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateRequestDto;
import com.aston.frontendpracticeservice.domain.dto.create.PersonalInformationCreateResponseDto;
import com.aston.frontendpracticeservice.domain.response.SimpleMessage;
import com.aston.frontendpracticeservice.domain.response.UserInfoDto;
import com.aston.frontendpracticeservice.facade.UserFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserFacade userFacade;

    @GetMapping(("/{id}"))
    @ResponseStatus(OK)
    @Operation(summary = "Gets user info by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserInfoDto.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SimpleMessage.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SimpleMessage.class))),
            }
    )
    public UserInfoDto findUserInfoById(@PathVariable UUID id) {
        return userFacade.getUserInfo(id);
    }


    @PostMapping("/creation")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Добавление юзера")
    public PersonalInformationCreateResponseDto addUser(
            @Valid
            @RequestBody PersonalInformationCreateRequestDto personalInformationCreateRequestDto) {
        log.info("Add new user with data: {}", personalInformationCreateRequestDto);
        return userFacade.addUser(personalInformationCreateRequestDto);
    }

}
