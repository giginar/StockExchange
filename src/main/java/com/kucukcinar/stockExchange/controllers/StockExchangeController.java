package com.kucukcinar.stockExchange.controllers;

import com.kucukcinar.stockExchange.dto.StockExchangeDTO;
import com.kucukcinar.stockExchange.entities.Stock;
import com.kucukcinar.stockExchange.entities.StockExchange;
import com.kucukcinar.stockExchange.mappers.StockExchangeMapper;
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
    public StockExchangeDTO getStockExchange(@PathVariable String name) {
        StockExchange stockExchange = stockExchangeService.getStockExchangeByName(name);
        return StockExchangeMapper.toDTO(stockExchange);
    }

    @PostMapping("/{name}")
    public StockExchangeDTO addStockToExchange(@PathVariable String name, @RequestBody Long stockId) {
        StockExchange stockExchange = stockExchangeService.addStockToExchange(name, stockId);
        return StockExchangeMapper.toDTO(stockExchange);
    }

    @DeleteMapping("/{name}")
    public StockExchangeDTO removeStockFromExchange(@PathVariable String name, @RequestBody Long stockId) {
        StockExchange stockExchange = stockExchangeService.removeStockFromExchange(name, stockId);
        return StockExchangeMapper.toDTO(stockExchange);
    }
}
