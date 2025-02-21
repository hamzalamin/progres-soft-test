package com.progressoft.progressofttest.mapper;

import com.progressoft.progressofttest.dto.ExchangeDealRequestDto;
import com.progressoft.progressofttest.dto.ExchangeDealResponseDto;
import com.progressoft.progressofttest.entity.ExchangeDeal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExchangeDealMapper {
    ExchangeDeal toEntity(ExchangeDealRequestDto exchangeDealRequestDto);
    ExchangeDealResponseDto toDto(ExchangeDeal exchangeDeal);
}
