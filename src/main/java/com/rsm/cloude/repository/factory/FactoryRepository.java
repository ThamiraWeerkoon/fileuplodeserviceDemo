package com.rsm.cloude.repository.factory;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.rsm.cloude.model.factory.Factory;

public interface FactoryRepository extends PagingAndSortingRepository<Factory, Long> {
	
//	Factory findFirstByFactoryIdAndTickerName(@Param("factoryId") Integer storeId,@Param("tickerName") String tickerName);
	
	Factory findFirstByTickerIdName(String id);
	Factory findFirstByTickerIdNameAndFactoryId(String name,int id);
}
