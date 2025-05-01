package com.example.thinkhumble.service;



import com.example.thinkhumble.dto.QuoteResponse;

import java.util.List;

public interface StockService {
    QuoteResponse getQuote(String symbol);
    List<QuoteResponse> getBatchQuotes(List<String> symbols);
}
