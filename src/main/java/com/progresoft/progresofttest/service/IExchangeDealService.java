package com.progresoft.progresofttest.service;

import com.progresoft.progresofttest.dto.ExchangeDealRequestDto;
import com.progresoft.progresofttest.dto.ExchangeDealResponseDto;

public interface IExchangeDealService {
    ExchangeDealResponseDto save(ExchangeDealRequestDto dto);
}
