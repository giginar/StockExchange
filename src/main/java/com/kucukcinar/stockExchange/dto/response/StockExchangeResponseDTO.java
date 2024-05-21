package com.kucukcinar.stockExchange.dto.response;

import java.util.List;

public class StockExchangeDTO {
    private Long id;
    private String name;
    private String description;
    private boolean liveInMarket;
    private List<StockResponseDTO> stocks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLiveInMarket() {
        return liveInMarket;
    }

    public void setLiveInMarket(boolean liveInMarket) {
        this.liveInMarket = liveInMarket;
    }

    public List<StockResponseDTO> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockResponseDTO> stocks) {
        this.stocks = stocks;
    }
}
