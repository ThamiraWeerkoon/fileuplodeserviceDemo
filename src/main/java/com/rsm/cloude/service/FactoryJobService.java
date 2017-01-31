package com.rsm.cloude.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rsm.cloude.model.factory.FactoryChecklist;
import com.rsm.cloude.model.factory.FactoryJob;
import com.rsm.cloude.model.factory.helper.FactoryDto;
import com.rsm.cloude.repository.factory.FactoryJobRepository;
//import com.rsm.platform.models.common.State;
//import com.rsm.platform.models.common.Ticker;
//import com.rsm.platform.models.workflow.enums.JobStatus;
//import com.rsm.platform.models.workflow.factory.Factory;
//import com.rsm.platform.models.workflow.factory.FactoryCheckList;
//import com.rsm.platform.utils.SatelliteImageProvidersUtils;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class FactoryJobService {
	
	@Autowired
	private FactoryJobRepository factoryJobRepository;

//	private ResponseEntity<?> procesRecords(ArrayList<FactoryDto> rowRecords, FactoryChecklist excel) {
//		log.info("Records proccesing completed");
//		try {
//			ArrayList<FactoryJob> jobs = getJobs(rowRecords, excel);
//			log.info("Saving " + jobs.size() + "jobs");
//			factoryJobRepository.save(jobs);
//			log.info("Save Complete");
//			return ResponseEntity.status(HttpStatus.CREATED).body("Job Save Successful");
//		} catch (Exception e) {
//			log.error("Error Saving Jobs", e);
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Job Save Successful");
//		}
//	}// End procesRecords()
	
//	private ArrayList<FactoryJob> getJobs(ArrayList<FactoryDto> rowRecords, FactoryChecklist excel)
//			throws Exception {
//
//		HashMap<String, Factory> factories = new HashMap<String, Factory>();
//		HashMap<String, Ticker> tickers = new HashMap<String, Ticker>();
//		HashMap<String, State> states = new HashMap<String, State>();
//		HashMap<String, State> stateNames = new HashMap<String, State>();
//
//		ArrayList<FactoryJob> jobs = new ArrayList<FactoryJob>();
//
//		// put states to the map
//		stateRepository.findAll().forEach(state -> {
//			states.put(state.getAbbr(), state);
//			if (state.getName() != null)
//				stateNames.put(state.getName().toLowerCase(), state);
//		});
//
//		// put tickers to the map
//		tickerRepository.findAll().forEach(ticker -> {
//			tickers.put(ticker.getName(), ticker);
//		});
//
//		rowRecords.forEach(r -> {
//			FactoryJob job = new FactoryJob();
//			if (excel != null) {
//				job.setCheckListExcel(excel);
//			}
//			
//			if (r.getTicker() == null) {
//				return;
//			}
//
//			// Check ticker in the Map
//			Ticker ticker = tickers.get(r.getTicker());
//			if (ticker == null) {
//				ticker = new Ticker();
//				ticker.setName(r.getTicker());
//				tickers.put(r.getTicker(), ticker);
//			}
//
//			State state = null;
//			// Check the state abbreviation length
//			if (r.getState() != null && r.getState().length() > 2) {
//				state = stateNames.get(r.getState().toLowerCase().trim());
//			} else {
//				state = states.get(r.getState());
//			}
//			//System.err.println(state);
//
//			// Check in the Map
//			Factory factory = factories.get(r.getTicker() + r.getFactoryId());
//
//			if (factory == null) {
//				try {
//					factory = factoryRepository.findFirstByFactoryIdAndTickerName(r.getFactoryId(), r.getTicker());
//				} catch (Exception e) {
//					log.error("Error gettig Store", e);
//				}
//
//				// if the store is null then Create a new Store
//				if (factory == null) {
//					factory = new Factory(ticker, r.getFactoryId(), r.getAddress(), state, r.getZip(),
//							r.getLatitude(), r.getLongtitude());
//				}
//				factories.put(r.getTicker() + r.getFactoryId(), factory);
//			}
//
//			// Set the store
//			job.setFactory(factory);
//			Date date = SatelliteImageProvidersUtils.getDateFromDirectory(r.getDirectory());
//			if (date == null) {
//				return;
//			}
//			job.setDate(date);
//			job.setMatchId(r.getMatchID());
//			job.setName(r.getName());
//			job.setDirectory(r.getDirectory());
//			job.setStatus(JobStatus.PENDING);
//
//			jobs.add(job);
//			
//		}); // End Lamda
//
//		log.info("Records proccesing completed");
//		try {
//			log.info("Saving " + tickers.size() + " tickers");
//			tickerRepository.save(tickers.values());
//
//			log.info("Saving " + states.size() + " states");
//			stateRepository.save(states.values());
//
//			log.info("Saving " + factories.size() + " stores");
//			factoryRepository.save(factories.values());
//
//			if (excel != null) {
//				try {
//					log.info("Saving Excel File :" + excel.getFileName());
//					factoryCheckListRepository.save(excel);
//				} catch (DataIntegrityViolationException e) {
//					log.error("Checklist already exists", e.getMessage());
//					throw new Exception("Checklist already exists");
//				}
//			}
//			return jobs;
//		} catch (Exception e) {
//			log.error("Error Saving Jobs", e);
//			throw new Exception("Error saving Jobs");
//		}
//	}// End getJobs()
}
