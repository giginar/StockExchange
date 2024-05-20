package com.kucukcinar.stockExchange.repositories;

import com.kucukcinar.stockExchange.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
