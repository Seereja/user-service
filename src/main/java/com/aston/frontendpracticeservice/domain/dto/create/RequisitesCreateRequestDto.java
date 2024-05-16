package com.aston.frontendpracticeservice.domain.dto.create;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.BIK_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.CORRESPONDENT_ACCOUNT_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.INN_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.KBK_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.KPP_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsMessage.SETTLEMENT_ACCOUNT_VALID_MESSAGE;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.BIK_VALID;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.CORRESPONDENT_ACCOUNT_VALID;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.KBK_VALID;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.KPP_VALID;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.PATTERN_VALID_INN;
import static com.aston.frontendpracticeservice.domain.dto.utils.ConstantsValidateRequest.SETTLEMENT_ACCOUNT_VALID;

@Schema(description = "Добавление реквизитных данных юзера")
public record RequisitesCreateRequestDto(

        @NotNull
        @Schema(description = "Расчетный счет", example = "12345678901234567890")
        @Pattern(regexp = SETTLEMENT_ACCOUNT_VALID,
                message = SETTLEMENT_ACCOUNT_VALID_MESSAGE)
        String settlementAccount,

        @NotNull
        @Schema(description = "БИК", example = "044525225")
        @Pattern(regexp = BIK_VALID,
                message = BIK_VALID_MESSAGE)
        String bik,


        @NotNull
        @Schema(description = "Корреспондентский счет", example = "30101810200000000600")
        @Pattern(regexp = CORRESPONDENT_ACCOUNT_VALID,
                message = CORRESPONDENT_ACCOUNT_VALID_MESSAGE)
        String correspondentAccount,


        @Schema(description = "ИНН", example = "7123567891")
        @Pattern(regexp = PATTERN_VALID_INN,
                message = INN_VALID_MESSAGE)
        String inn,

        @Schema(description = "КПП", example = "123456789")
        @Pattern(regexp = KPP_VALID,
                message = KPP_VALID_MESSAGE)
        String kpp,

        @NotNull
        @Schema(description = "КБК", example = "12345678901234567890")
        @Pattern(regexp = KBK_VALID,
                message = KBK_VALID_MESSAGE)
        String kbk
) {
}
