package com.rsm.cloude.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.rsm.cloude.model.factory.FactoryLotCount;
import com.rsm.cloude.reservation.ObjectReservation;




public class ObjectReservationService {
	
	public synchronized String objectReservation(){
		Map<String, String> j=ObjectReservation.getObjectReservation().getObjectMap();
		Set<String> m=j.keySet();
		for (String string : m) {
			String x=j.get(string);
			j.remove(string);
			return x;
		}
		
		return null;
	}
	
	public void reservationSetObject(FactoryLotCount f){
		Map<String, String> j=ObjectReservation.getObjectReservation().getObjectMap();
		Map<String,String> objectMap=new HashMap<>();
		if(j==null){
			ObjectReservation.getObjectReservation().setObjectMap(objectMap);
			j=ObjectReservation.getObjectReservation().getObjectMap();
		}
		
		String s=f.getFactoryJobId().getId()+"_"+f.getId()+"_"+f.getFactoryLotId().getFactoryLotNumber();
		if(!j.containsKey(Long.toString(f.getId()))){
			j.put(Long.toString(f.getId()),s);
		}
		
	}
	
}
