package com.example.thinkhumble.util;

import java.util.*;
import java.util.Map;

import com.example.thinkhumble.dto.QuoteResponse;
import com.example.thinkhumble.model.Quote;

public class QuoteMapper {

    public static QuoteResponse toDto(Quote quote) {
        return QuoteResponse.builder()
                .symbol(quote.getSymbol())
                .price(quote.getPrice())
                .change(quote.getChange())
                .percentChange(quote.getPercentChange())
                .timestamp(quote.getTimestamp())
                .build();
    }

    public static Quote fromApiResponse(Map<String, String> data) {
        return Quote.builder()
                .symbol(data.get("01. symbol"))
                .price(Double.parseDouble(data.get("05. price")))
                .change(Double.parseDouble(data.get("09. change")))
                .percentChange(data.get("10. change percent"))
                .timestamp(new Date())
                .build();
    }
}
