package com.kucukcinar.stockExchange.services;

import com.kucukcinar.stockExchange.entities.Stock;
import com.kucukcinar.stockExchange.exceptions.EntityNotFoundException;
import com.kucukcinar.stockExchange.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStockPrice(Long stockId, BigDecimal newPrice) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found: " + stockId));
        stock.setCurrentPrice(newPrice);
        stock.setLastUpdate(LocalDateTime.now());
        return stockRepository.save(stock);
    }

    public void deleteStock(Long stockId) {
        if (!stockRepository.existsById(stockId)) {
            throw new EntityNotFoundException("Stock not found: " + stockId);
        }
        stockRepository.deleteById(stockId);
    }
}
