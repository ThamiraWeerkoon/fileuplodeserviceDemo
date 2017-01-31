package com.rsm.cloude.repository.factory;

import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rsm.cloude.model.factory.FactoryChecklist;

@Repository
public interface FactoryChecklistRepository extends PagingAndSortingRepository<FactoryChecklist,Long> {
//	public FactoryChecklist findAllFactoryChecklist();
	
	public ArrayList<FactoryChecklist> findAllByStatus(int state);
}
