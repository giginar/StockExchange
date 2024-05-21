package com.kucukcinar.stockExchange.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockRequestDTO {
    private String name;
    private String description;
    private BigDecimal currentPrice;
}
