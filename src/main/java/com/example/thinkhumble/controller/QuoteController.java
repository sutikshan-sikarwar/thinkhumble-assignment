package com.example.thinkhumble.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.thinkhumble.dto.QuoteResponse;
import com.example.thinkhumble.service.StockService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final StockService stockService;

    @Operation(summary = "Get stock quote by symbol")
    @GetMapping("/{symbol}")
    public ResponseEntity<QuoteResponse> getQuote(@PathVariable String symbol) {
        return ResponseEntity.ok(stockService.getQuote(symbol));
    }

    @Operation(summary = "Get quotes for multiple symbols")
    @GetMapping("/batch")
    public ResponseEntity<List<QuoteResponse>> getBatchQuotes(@RequestParam List<String> symbols) {
        return ResponseEntity.ok(stockService.getBatchQuotes(symbols));
    }
}