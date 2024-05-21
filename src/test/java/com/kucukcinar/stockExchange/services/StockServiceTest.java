package com.kucukcinar.stockExchange.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import com.kucukcinar.stockExchange.entities.Stock;
import com.kucukcinar.stockExchange.exceptions.EntityNotFoundException;
import com.kucukcinar.stockExchange.repositories.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StockServiceTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateStock() {
        Stock stock = new Stock();
        stock.setName("Stock A");
        stock.setDescription("Description A");
        stock.setCurrentPrice(new BigDecimal("100.0"));
        stock.setLastUpdate(LocalDateTime.now());

        when(stockRepository.save(stock)).thenReturn(stock);

        Stock createdStock = stockService.createStock(stock);

        assertEquals("Stock A", createdStock.getName());
        assertEquals("Description A", createdStock.getDescription());
        assertEquals(new BigDecimal("100.0"), createdStock.getCurrentPrice());
        verify(stockRepository, times(1)).save(stock);
    }

    @Test
    public void testUpdateStockPrice() {
        Stock stock = new Stock();
        stock.setId(1L);
        stock.setName("Stock A");
        stock.setDescription("Description A");
        stock.setCurrentPrice(new BigDecimal("100.0"));
        stock.setLastUpdate(LocalDateTime.now());

        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
        when(stockRepository.save(stock)).thenReturn(stock);

        Stock updatedStock = stockService.updateStockPrice(1L, new BigDecimal("120.0"));

        assertEquals(new BigDecimal("120.0"), updatedStock.getCurrentPrice());
        verify(stockRepository, times(1)).findById(1L);
        verify(stockRepository, times(1)).save(stock);
    }

    @Test
    public void testDeleteStock() {
        when(stockRepository.existsById(1L)).thenReturn(true);
        doNothing().when(stockRepository).deleteById(1L);

        stockService.deleteStock(1L);

        verify(stockRepository, times(1)).existsById(1L);
        verify(stockRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteStockNotFound() {
        when(stockRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            stockService.deleteStock(1L);
        });

        assertEquals("Stock not found: 1", exception.getMessage());
        verify(stockRepository, times(1)).existsById(1L);
        verify(stockRepository, times(0)).deleteById(1L);
    }
}
