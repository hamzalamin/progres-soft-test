package com.progressoft.progressofttest.service;

import com.progressoft.progressofttest.dto.ExchangeDealRequestDto;
import com.progressoft.progressofttest.dto.ExchangeDealResponseDto;

public interface ExchangeDealService {
    ExchangeDealResponseDto save(ExchangeDealRequestDto dto);
}
