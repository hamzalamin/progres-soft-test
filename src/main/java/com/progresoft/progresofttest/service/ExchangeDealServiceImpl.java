package com.progresoft.progresofttest.service;

import com.progresoft.progresofttest.Exception.DuplicateIdException;
import com.progresoft.progresofttest.Exception.SameCurrencyException;
import com.progresoft.progresofttest.dto.ExchangeDealRequestDto;
import com.progresoft.progresofttest.dto.ExchangeDealResponseDto;
import com.progresoft.progresofttest.entity.ExchangeDeal;
import com.progresoft.progresofttest.mapper.ExchangeDealMapper;
import com.progresoft.progresofttest.repository.ExchangeDealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeDealServiceImpl implements IExchangeDealService {

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
        if (dto.fromCurrency() == dto.toCurrency()){
            log.warn("From currency and to currency cannot be the same for deal ID");
            throw new SameCurrencyException("From currency and to currency cannot be the same for deal ID");
        }
    }
}
