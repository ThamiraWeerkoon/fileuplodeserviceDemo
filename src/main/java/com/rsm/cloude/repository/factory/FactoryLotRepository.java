package com.rsm.cloude.repository.factory;

import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rsm.cloude.model.factory.FactoryLot;

@Repository
public interface FactoryLotRepository extends PagingAndSortingRepository<FactoryLot, Long>{
//	Factory findFirstByFactoryIdAndTickerName(@Param("factoryId") Integer storeId,@Param("tickerName") String tickerName);
	ArrayList<FactoryLot> findAllByFactoryId(Long id);

}
