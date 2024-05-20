package com.kucukcinar.stockExchange.mappers;

import com.kucukcinar.stockExchange.dto.StockDTO;
import com.kucukcinar.stockExchange.entities.Stock;

import java.util.List;
import java.util.stream.Collectors;

public class StockMapper {

    public static StockDTO toDTO(Stock stock) {
        StockDTO dto = new StockDTO();
        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setDescription(stock.getDescription());
        dto.setCurrentPrice(stock.getCurrentPrice());
        dto.setLastUpdate(stock.getLastUpdate());
        return dto;
    }

    public static List<StockDTO> toDTOs(List<Stock> stocks) {
        return stocks.stream().map(StockMapper::toDTO).collect(Collectors.toList());
    }
}
