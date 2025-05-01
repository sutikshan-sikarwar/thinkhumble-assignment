package com.example.thinkhumble.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote {

    @Id
    private String id;

    private String symbol;
    private double price;
    private double change;
    private String percentChange;

    private Date timestamp; // ✅ Changed from java.sql.Date to java.util.Date
}
