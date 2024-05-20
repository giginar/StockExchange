package com.kucukcinar.stockExchange.controllers;

import com.kucukcinar.stockExchange.dto.StockDTO;
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
    public StockDTO createStock(@RequestBody StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setName(stockDTO.getName());
        stock.setDescription(stockDTO.getDescription());
        stock.setCurrentPrice(stockDTO.getCurrentPrice());
        stock.setLastUpdate(stockDTO.getLastUpdate());
        stock = stockService.createStock(stock);
        return StockMapper.toDTO(stock);
    }

    @PutMapping
    public StockDTO updateStockPrice(@RequestBody StockDTO stockDTO) {
        Stock stock = stockService.updateStockPrice(stockDTO.getId(), stockDTO.getCurrentPrice());
        return StockMapper.toDTO(stock);
    }

    @DeleteMapping
    public void deleteStock(@RequestBody Long stockId) {
        stockService.deleteStock(stockId);
    }
}
