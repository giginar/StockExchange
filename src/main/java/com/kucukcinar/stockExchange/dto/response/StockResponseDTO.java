package com.kucukcinar.stockExchange.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockResponseDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal currentPrice;
    private LocalDateTime lastUpdate;
}
