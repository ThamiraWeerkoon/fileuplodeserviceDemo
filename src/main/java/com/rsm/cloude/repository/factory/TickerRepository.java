package com.rsm.cloude.repository.factory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rsm.cloude.model.factory.Ticker;

@Repository
public interface TickerRepository extends PagingAndSortingRepository<Ticker, Long>{
	
}
