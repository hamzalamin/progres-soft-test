package com.progressoft.progressofttest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Table(name = "exchange_deals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDeal {
    @Id
    @NotBlank
    private String id;

    @NotNull
    private Currency fromCurrency;

    @NotNull
    private Currency toCurrency;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    @Positive
    private BigDecimal amount;
}
