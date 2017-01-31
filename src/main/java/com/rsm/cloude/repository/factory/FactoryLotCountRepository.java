package com.rsm.cloude.repository.factory;

import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rsm.cloude.model.factory.Factory;
import com.rsm.cloude.model.factory.FactoryLotCount;

@Repository
public interface FactoryLotCountRepository extends PagingAndSortingRepository<FactoryLotCount, Long>{
	 ArrayList<FactoryLotCount> findAllByStatus(int x);
}
