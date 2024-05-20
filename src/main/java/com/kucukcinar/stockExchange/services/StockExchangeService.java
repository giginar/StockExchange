package com.kucukcinar.stockExchange.services;

import com.kucukcinar.stockExchange.entities.Stock;
import com.kucukcinar.stockExchange.entities.StockExchange;
import com.kucukcinar.stockExchange.exceptions.EntityNotFoundException;
import com.kucukcinar.stockExchange.repositories.StockExchangeRepository;
import com.kucukcinar.stockExchange.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockExchangeService {
    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Autowired
    private StockRepository stockRepository;

    public StockExchange getStockExchangeByName(String name) {
        return stockExchangeRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("StockExchange not found: " + name));
    }

    public StockExchange addStockToExchange(String exchangeName, Long stockId) {
        StockExchange stockExchange = getStockExchangeByName(exchangeName);
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found: " + stockId));
        stockExchange.getStocks().add(stock);
        stockExchange.setLiveInMarket(stockExchange.getStocks().size() >= 5);
        return stockExchangeRepository.save(stockExchange);
    }

    public StockExchange removeStockFromExchange(String exchangeName, Long stockId) {
        StockExchange stockExchange = getStockExchangeByName(exchangeName);
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found: " + stockId));
        stockExchange.getStocks().remove(stock);
        stockExchange.setLiveInMarket(stockExchange.getStocks().size() >= 5);
        return stockExchangeRepository.save(stockExchange);
    }
}
