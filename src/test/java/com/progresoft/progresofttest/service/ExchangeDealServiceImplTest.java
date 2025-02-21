package com.progresoft.progresofttest.service;

import com.progresoft.progresofttest.Exception.DuplicateIdException;
import com.progresoft.progresofttest.Exception.SameCurrencyException;
import com.progresoft.progresofttest.dto.ExchangeDealRequestDto;
import com.progresoft.progresofttest.dto.ExchangeDealResponseDto;
import com.progresoft.progresofttest.entity.ExchangeDeal;
import com.progresoft.progresofttest.mapper.ExchangeDealMapper;
import com.progresoft.progresofttest.repository.ExchangeDealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ExchangeDealServiceImplTest {

    @Mock
    private ExchangeDealRepository dealRepository;
    @Mock
    private ExchangeDealMapper dealMapper;

    private IExchangeDealService sut;

    private ExchangeDealRequestDto exchangeDealRequestDto;
    private ExchangeDeal exchangeDeal;

    @BeforeEach
    void setup() {
        sut = new ExchangeDealServiceImpl(dealRepository, dealMapper);
        exchangeDealRequestDto = new ExchangeDealRequestDto("exchangeDeal-123",
                Currency.getInstance("MAD"),
                Currency.getInstance("USD"),
                LocalDateTime.now(),
                BigDecimal.valueOf(2000)
        );

        exchangeDeal = new ExchangeDeal(exchangeDealRequestDto.id(),
                exchangeDealRequestDto.fromCurrency(),
                exchangeDealRequestDto.toCurrency(),
                exchangeDealRequestDto.timestamp(),
                exchangeDealRequestDto.amount());
    }

    @Test
    void testCreateDeal_withValidFields_shouldReturnSuccess() {
        given(dealMapper.toEntity(exchangeDealRequestDto)).willReturn(exchangeDeal);
        given(dealRepository.save(any(ExchangeDeal.class))).willReturn(exchangeDeal);
        given(dealMapper.toDto(exchangeDeal))
                .willReturn(new ExchangeDealResponseDto(
                        exchangeDealRequestDto.id(),
                        exchangeDealRequestDto.fromCurrency(),
                        exchangeDealRequestDto.toCurrency(),
                        exchangeDealRequestDto.timestamp(),
                        exchangeDealRequestDto.amount()
                ));

        ExchangeDealResponseDto actual = sut.save(exchangeDealRequestDto);

        assertThat(actual).isNotNull();
        assertThat(actual.id()).isEqualTo(exchangeDeal.getId());
        verify(dealRepository).save(any(ExchangeDeal.class));
    }


    @Test
    void givenDealIdAlreadyExists_whenSave_thenThrowDuplicatedDealIdException() {
        given(dealRepository.existsById(exchangeDealRequestDto.id())).willReturn(true);

        assertThatExceptionOfType(DuplicateIdException.class)
                .isThrownBy(() -> sut.save(exchangeDealRequestDto))
                .withMessage("this id : " + exchangeDealRequestDto.id() + " Already exist");
    }


    @Test
    void givenSameCurrency_whenSave_thenThrowSameCurrencyException() {
        ExchangeDealRequestDto sameCurrencyDealRequestDto = new ExchangeDealRequestDto(
                "exchangeDeal-124",
                Currency.getInstance("USD"),
                Currency.getInstance("USD"),
                LocalDateTime.now(),
                BigDecimal.valueOf(1000)
        );

        assertThatExceptionOfType(SameCurrencyException.class)
                .isThrownBy(() -> sut.save(sameCurrencyDealRequestDto))
                .withMessage("From currency and to currency cannot be the same for deal ID");
    }


}