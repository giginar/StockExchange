package com.kucukcinar.stockExchange.mappers;

import com.kucukcinar.stockExchange.dto.response.StockExchangeResponseDTO;
import com.kucukcinar.stockExchange.entities.StockExchange;

import java.util.List;
import java.util.stream.Collectors;

public class StockExchangeMapper {

    public static StockExchangeResponseDTO toResponseDTO(StockExchange stockExchange) {
        StockExchangeResponseDTO dto = new StockExchangeResponseDTO();
        dto.setId(stockExchange.getId());
        dto.setName(stockExchange.getName());
        dto.setDescription(stockExchange.getDescription());
        dto.setLiveInMarket(stockExchange.isLiveInMarket());
        dto.setStocks(StockMapper.toResponseDTOs(stockExchange.getStocks()));
        return dto;
    }

    public static List<StockExchangeResponseDTO> toResponseDTOs(List<StockExchange> stockExchanges) {
        return stockExchanges.stream().map(StockExchangeMapper::toResponseDTO).collect(Collectors.toList());
    }
}
