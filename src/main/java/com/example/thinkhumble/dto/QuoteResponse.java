package com.example.thinkhumble.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class QuoteResponse {
    private String symbol;
    private double price;
    private double change;
    private String percentChange;
    private Date timestamp;
}
