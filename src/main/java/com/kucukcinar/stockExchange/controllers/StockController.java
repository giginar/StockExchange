package com.kucukcinar.stockExchange.controllers;

import com.kucukcinar.stockExchange.dto.request.StockRequestDTO;
import com.kucukcinar.stockExchange.dto.request.StockUpdateRequestDTO;
import com.kucukcinar.stockExchange.dto.response.StockResponseDTO;
import com.kucukcinar.stockExchange.entities.Stock;
import com.kucukcinar.stockExchange.mappers.StockMapper;
import com.kucukcinar.stockExchange.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping
    public StockResponseDTO createStock(@RequestBody StockRequestDTO stockRequestDTO) {
        Stock stock = stockService.createStock(StockMapper.toEntity(stockRequestDTO));
        return StockMapper.toResponseDTO(stock);
    }

    @PutMapping
    public StockResponseDTO updateStockPrice(@RequestBody StockUpdateRequestDTO stockUpdateRequestDTO) {
        Stock stock = stockService.updateStockPrice(stockUpdateRequestDTO.getId(), stockUpdateRequestDTO.getCurrentPrice());
        return StockMapper.toResponseDTO(stock);
    }

    @DeleteMapping
    public void deleteStock(@RequestBody Long stockId) {
        stockService.deleteStock(stockId);
    }
}
