package com.progressoft.progressofttest.service;

import com.progressoft.progressofttest.Exception.DuplicateIdException;
import com.progressoft.progressofttest.Exception.SameCurrencyException;
import com.progressoft.progressofttest.dto.ExchangeDealRequestDto;
import com.progressoft.progressofttest.dto.ExchangeDealResponseDto;
import com.progressoft.progressofttest.entity.ExchangeDeal;
import com.progressoft.progressofttest.mapper.ExchangeDealMapper;
import com.progressoft.progressofttest.repository.ExchangeDealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeDealServiceImpl implements ExchangeDealService {

    private final ExchangeDealRepository repository;
    private final ExchangeDealMapper mapper;

    @Override
    public ExchangeDealResponseDto save(ExchangeDealRequestDto dto) {
        log.info("Saving deal with ID {} in progress..", dto.id());

        validateDealId(dto);
        validateCurrency(dto);

        ExchangeDeal savedExchangeDeal = repository.save(mapper.toEntity(dto));
        log.info("Deal with ID {} saved successfully.", savedExchangeDeal.getId());

        return mapper.toDto(savedExchangeDeal);
    }

    private void validateDealId(ExchangeDealRequestDto dto) {
        if (repository.existsById(dto.id())){
            log.warn("Deal with ID {} already exists. Aborting operation.", dto.id());
            throw new DuplicateIdException(dto.id());
        }
    }

    private static void validateCurrency(ExchangeDealRequestDto dto) {
        if (dto.fromCurrency().equals(dto.toCurrency())){
            log.warn("From currency and to currency cannot be the same for deal ID");
            throw new SameCurrencyException("From currency and to currency cannot be the same for deal ID");
        }
    }
}
