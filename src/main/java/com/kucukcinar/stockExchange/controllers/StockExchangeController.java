package com.kucukcinar.stockExchange.controllers;

import com.kucukcinar.stockExchange.entities.Stock;
import com.kucukcinar.stockExchange.entities.StockExchange;
import com.kucukcinar.stockExchange.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stock-exchange")
public class StockExchangeController {
    @Autowired
    private StockExchangeService stockExchangeService;

    @GetMapping("/{name}")
    public StockExchange getStockExchange(@PathVariable String name) {
        return stockExchangeService.getStockExchangeByName(name);
    }

    @PostMapping("/{name}")
    public StockExchange addStockToExchange(@PathVariable String name, @RequestBody Long stockId) {
        return stockExchangeService.addStockToExchange(name, stockId);
    }

    @DeleteMapping("/{name}")
    public StockExchange removeStockFromExchange(@PathVariable String name, @RequestBody Long stockId) {
        return stockExchangeService.removeStockFromExchange(name, stockId);
    }
}
