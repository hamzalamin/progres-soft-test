package com.progresoft.progresofttest.mapper;

import com.progresoft.progresofttest.dto.ExchangeDealRequestDto;
import com.progresoft.progresofttest.dto.ExchangeDealResponseDto;
import com.progresoft.progresofttest.entity.ExchangeDeal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExchangeDealMapper {
    ExchangeDeal toEntity(ExchangeDealRequestDto exchangeDealRequestDto);
    ExchangeDealResponseDto toDto(ExchangeDeal exchangeDeal);
}
