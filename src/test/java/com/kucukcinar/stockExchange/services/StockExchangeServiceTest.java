package com.kucukcinar.stockExchange.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.kucukcinar.stockExchange.entities.Stock;
import com.kucukcinar.stockExchange.entities.StockExchange;
import com.kucukcinar.stockExchange.repositories.StockExchangeRepository;
import com.kucukcinar.stockExchange.repositories.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StockExchangeServiceTest {

    @Mock
    private StockExchangeRepository stockExchangeRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockExchangeService stockExchangeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStockExchangeByName() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.setName("Exchange 1");

        when(stockExchangeRepository.findByName("Exchange 1")).thenReturn(Optional.of(stockExchange));

        StockExchange foundStockExchange = stockExchangeService.getStockExchangeByName("Exchange 1");

        assertEquals("Exchange 1", foundStockExchange.getName());
        verify(stockExchangeRepository, times(1)).findByName("Exchange 1");
    }

    @Test
    public void testAddStockToExchange() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.setName("Exchange 1");

        Stock stock = new Stock();
        stock.setId(1L);
        stock.setName("Stock A");

        when(stockExchangeRepository.findByName("Exchange 1")).thenReturn(Optional.of(stockExchange));
        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
        when(stockExchangeRepository.save(stockExchange)).thenReturn(stockExchange);

        StockExchange updatedStockExchange = stockExchangeService.addStockToExchange("Exchange 1", 1L);

        assertEquals(1, updatedStockExchange.getStocks().size());
        assertTrue(updatedStockExchange.getStocks().contains(stock));
        verify(stockExchangeRepository, times(1)).findByName("Exchange 1");
        verify(stockRepository, times(1)).findById(1L);
        verify(stockExchangeRepository, times(1)).save(stockExchange);
    }

    @Test
    public void testRemoveStockFromExchange() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.setName("Exchange 1");

        Stock stock = new Stock();
        stock.setId(1L);
        stock.setName("Stock A");
        stockExchange.getStocks().add(stock);

        when(stockExchangeRepository.findByName("Exchange 1")).thenReturn(Optional.of(stockExchange));
        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
        when(stockExchangeRepository.save(stockExchange)).thenReturn(stockExchange);

        StockExchange updatedStockExchange = stockExchangeService.removeStockFromExchange("Exchange 1", 1L);

        assertEquals(0, updatedStockExchange.getStocks().size());
        assertFalse(updatedStockExchange.getStocks().contains(stock));
        verify(stockExchangeRepository, times(1)).findByName("Exchange 1");
        verify(stockRepository, times(1)).findById(1L);
        verify(stockExchangeRepository, times(1)).save(stockExchange);
    }
}
