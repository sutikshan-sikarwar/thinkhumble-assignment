package com.example.thinkhumble.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.thinkhumble.client.StockApiClient;
import com.example.thinkhumble.dto.QuoteResponse;
import com.example.thinkhumble.service.StockService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockApiClient stockApiClient;

    @Override
    public QuoteResponse getQuote(String symbol) {
        return stockApiClient.getQuoteBySymbol(symbol);
    }

    @Override
    public List<QuoteResponse> getBatchQuotes(List<String> symbols) {
        return stockApiClient.getBatchQuotes(symbols);
    }
}