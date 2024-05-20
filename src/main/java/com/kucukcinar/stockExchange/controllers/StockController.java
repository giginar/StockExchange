package com.kucukcinar.stockExchange.controllers;

import com.kucukcinar.stockExchange.entities.Stock;
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
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    @PutMapping
    public Stock updateStockPrice(@RequestBody Stock stock) {
        return stockService.updateStockPrice(stock.getId(), stock.getCurrentPrice());
    }

    @DeleteMapping
    public void deleteStock(@RequestBody Long stockId) {
        stockService.deleteStock(stockId);
    }
}
