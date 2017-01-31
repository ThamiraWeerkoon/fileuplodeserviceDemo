package com.rsm.cloude.controller;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsm.cloude.model.factory.FactoryChecklist;
import com.rsm.cloude.model.factory.FactoryLotCount;
import com.rsm.cloude.repository.factory.FactoryChecklistRepository;
import com.rsm.cloude.repository.factory.FactoryLotCountRepository;
import com.rsm.cloude.service.ObjectReservationService;


@RequestMapping(value = "/userlog/")
@RestController
public class ReservationController {
	
	@Autowired
	private FactoryChecklistRepository factory;
	
	@Autowired
	private FactoryLotCountRepository factoryLotCount;
	
	@RequestMapping(value = "reserve", method = RequestMethod.GET)
	public ResponseEntity<?> setObject(@RequestParam("name") String userName) {
//				ObjectReservationService objectReservation=new ObjectReservationService();
//		objectReservation.reservationSetObject("hjdgjd");
		return ResponseEntity.ok(userName);
	}
	
	@RequestMapping(value = "job", method = RequestMethod.GET)
	public ResponseEntity<?> getObject() {
		String s=null;
		ObjectReservationService objectReservation=null;
		try{
			objectReservation=new ObjectReservationService();
			s=objectReservation.objectReservation();
		}catch (ConcurrentModificationException e) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			objectReservation=new ObjectReservationService();
			s=objectReservation.objectReservation();
		}
		
		return ResponseEntity.ok(s+"\n");
	}
	
	@RequestMapping(value = "jobset")
	public ResponseEntity<?> set() {
		ObjectReservationService objectReservation=new ObjectReservationService();
		ArrayList<FactoryLotCount> f=factoryLotCount.findAllByStatus(0);
		for (FactoryLotCount factoryLotCount : f) {
			objectReservation.reservationSetObject(factoryLotCount);
		}
//		System.out.println("hjgcjdd");
//		ObjectReservationService objectReservation=new ObjectReservationService();
//		
//		for (int i = 0; i < 50; i++) {
//			objectReservation.reservationSetObject(Integer.toString(i));
//		}
		
		
		return ResponseEntity.ok("success");
	}
	
	
	/*
	 for (int i = 0; i < 100000; i++) {
			
		}
	  */
}
