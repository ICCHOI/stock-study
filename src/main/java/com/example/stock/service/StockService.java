package com.example.stock.service;

import org.springframework.stereotype.Service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;

@Service
public class StockService {

	private StockRepository stockRepository;

	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	// @Transactional
	public synchronized void decrease(Long id, long quantity) {
		/**
		 * get stock + 재고감소 + 저장
		 */

		Stock stock = stockRepository.findById(id).orElseThrow();

		stock.decrease(quantity);

		stockRepository.saveAndFlush(stock);
	}
}