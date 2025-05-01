package com.example.thinkhumble.exception;


public class StockApiException extends RuntimeException {
    public StockApiException(String message) {
        super(message);
    }
}
