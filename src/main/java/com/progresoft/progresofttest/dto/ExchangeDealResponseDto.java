package com.progresoft.progresofttest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

public record ExchangeDealResponseDto(
        @NotBlank String id,
        @NotNull Currency fromCurrency,
        @NotNull Currency toCurrency,
        @NotNull LocalDateTime timestamp,
        @NotNull BigDecimal amount
) {
}
