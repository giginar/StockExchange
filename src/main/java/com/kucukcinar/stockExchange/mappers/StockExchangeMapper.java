package com.kucukcinar.stockExchange.mappers;

import com.kucukcinar.stockExchange.dto.StockExchangeDTO;
import com.kucukcinar.stockExchange.entities.StockExchange;

import java.util.List;
import java.util.stream.Collectors;

public class StockExchangeMapper {

    public static StockExchangeDTO toDTO(StockExchange stockExchange) {
        StockExchangeDTO dto = new StockExchangeDTO();
        dto.setId(stockExchange.getId());
        dto.setName(stockExchange.getName());
        dto.setDescription(stockExchange.getDescription());
        dto.setLiveInMarket(stockExchange.isLiveInMarket());
        dto.setStocks(StockMapper.toDTOs(stockExchange.getStocks()));
        return dto;
    }

    public static List<StockExchangeDTO> toDTOs(List<StockExchange> stockExchanges) {
        return stockExchanges.stream().map(StockExchangeMapper::toDTO).collect(Collectors.toList());
    }
}
