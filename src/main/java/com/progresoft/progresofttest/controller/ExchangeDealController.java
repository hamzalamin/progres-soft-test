package com.progresoft.progresofttest.controller;

import com.progresoft.progresofttest.dto.ExchangeDealRequestDto;
import com.progresoft.progresofttest.dto.ExchangeDealResponseDto;
import com.progresoft.progresofttest.service.IExchangeDealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/deals")
@RequiredArgsConstructor
public class ExchangeDealController {
    private final IExchangeDealService exchangeDealService;

    @PostMapping
    public ResponseEntity<ExchangeDealResponseDto> save(@RequestBody @Valid ExchangeDealRequestDto dto){
        return new ResponseEntity<>(exchangeDealService.save(dto), HttpStatus.CREATED);
    }

}
