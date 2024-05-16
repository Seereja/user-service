package com.aston.frontendpracticeservice.domain.dto.create;


import java.util.UUID;

public record RequisitesCreateResponseDto(

        UUID id,

        String settlementAccount,

        String bik,

        String correspondentAccount,

        String inn,

        String kpp,

        String kbk
) {
}
