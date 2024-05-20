package com.kucukcinar.stockExchange.repositories;

import com.kucukcinar.stockExchange.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {
    Optional<StockExchange> findByName(String name);
}
