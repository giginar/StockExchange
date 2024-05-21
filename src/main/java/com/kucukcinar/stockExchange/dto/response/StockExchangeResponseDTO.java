package com.kucukcinar.stockExchange.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockExchangeResponseDTO {
    private Long id;
    private String name;
    private String description;
    private boolean liveInMarket;
    private List<StockResponseDTO> stocks;
}
