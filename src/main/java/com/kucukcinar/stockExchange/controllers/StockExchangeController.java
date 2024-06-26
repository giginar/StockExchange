package com.kucukcinar.stockExchange.controllers;

import com.kucukcinar.stockExchange.dto.request.StockExchangeStockRequestDTO;
import com.kucukcinar.stockExchange.dto.response.StockExchangeResponseDTO;
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

    /**
     * Gets stock exchange.
     *
     * @param name the name
     * @return the stock exchange
     */
    @GetMapping("/{name}")
    public StockExchangeResponseDTO getStockExchange(@PathVariable String name) {
        StockExchange stockExchange = stockExchangeService.getStockExchangeByName(name);
        return StockExchangeMapper.toResponseDTO(stockExchange);
    }

    /**
     * Add stock to exchange stock exchange response dto.
     *
     * @param name       the name
     * @param requestDTO the request dto
     * @return the stock exchange response dto
     */
    @PostMapping("/{name}")
    public StockExchangeResponseDTO addStockToExchange(@PathVariable String name, @RequestBody StockExchangeStockRequestDTO requestDTO) {
        StockExchange stockExchange = stockExchangeService.addStockToExchange(name, requestDTO.getStockId());
        return StockExchangeMapper.toResponseDTO(stockExchange);
    }

    /**
     * Remove stock from exchange stock exchange response dto.
     *
     * @param name       the name
     * @param requestDTO the request dto
     * @return the stock exchange response dto
     */
    @DeleteMapping("/{name}")
    public StockExchangeResponseDTO removeStockFromExchange(@PathVariable String name, @RequestBody StockExchangeStockRequestDTO requestDTO) {
        StockExchange stockExchange = stockExchangeService.removeStockFromExchange(name, requestDTO.getStockId());
        return StockExchangeMapper.toResponseDTO(stockExchange);
    }
}
