package com.example.thinkhumble.client;



import com.example.thinkhumble.dto.QuoteResponse;
import com.example.thinkhumble.exception.StockApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Component
public class StockApiClient {

    @Value("${alpha.vantage.api.url}")
    private String apiUrl;

    @Value("${alpha.vantage.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings("unchecked")
    public QuoteResponse getQuoteBySymbol(String symbol) {
        String url = UriComponentsBuilder
                .fromHttpUrl(apiUrl)
                .queryParam("function", "GLOBAL_QUOTE")
                .queryParam("symbol", symbol)
                .queryParam("apikey", apiKey)
                .toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        if (response == null || !response.containsKey("Global Quote")) {
            throw new StockApiException("Invalid or unavailable symbol: " + symbol);
        }

        Map<String, String> quote = (Map<String, String>) response.get("Global Quote");

        if (quote == null || quote.isEmpty()) {
            throw new StockApiException("No data found for symbol: " + symbol);
        }

        return QuoteResponse.builder()
                .symbol(quote.get("01. symbol"))
                .price(Double.parseDouble(quote.get("05. price")))
                .change(Double.parseDouble(quote.get("09. change")))
                .percentChange(quote.get("10. change percent"))
                .timestamp(new Date())
                .build();
    }

    public List<QuoteResponse> getBatchQuotes(List<String> symbols) {
        List<QuoteResponse> result = new ArrayList<>();
        for (String symbol : symbols) {
            try {
                result.add(getQuoteBySymbol(symbol));
            } catch (Exception e) {
                // log or skip gracefully
            }
        }
        return result;
    }
}
