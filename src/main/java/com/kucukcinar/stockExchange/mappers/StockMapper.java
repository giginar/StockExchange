package com.kucukcinar.stockExchange.mappers;

import com.kucukcinar.stockExchange.dto.request.StockRequestDTO;
import com.kucukcinar.stockExchange.dto.response.StockResponseDTO;
import com.kucukcinar.stockExchange.entities.Stock;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StockMapper {

    public static StockResponseDTO toResponseDTO(Stock stock) {
        StockResponseDTO dto = new StockResponseDTO();
        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setDescription(stock.getDescription());
        dto.setCurrentPrice(stock.getCurrentPrice());
        dto.setLastUpdate(stock.getLastUpdate());
        return dto;
    }

    public static List<StockResponseDTO> toResponseDTOs(List<Stock> stocks) {
        return stocks.stream().map(StockMapper::toResponseDTO).collect(Collectors.toList());
    }

    public static Stock toEntity(StockRequestDTO dto) {
        Stock stock = new Stock();
        stock.setName(dto.getName());
        stock.setDescription(dto.getDescription());
        stock.setCurrentPrice(dto.getCurrentPrice());
        stock.setLastUpdate(LocalDateTime.now());
        return stock;
    }
}
