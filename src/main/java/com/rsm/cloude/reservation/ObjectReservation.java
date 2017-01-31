package com.rsm.cloude.reservation;

import java.util.Map;

public class ObjectReservation {
	private static ObjectReservation object;
	private Map<String,String> objectMap;
	
	private ObjectReservation(){
	
	}
	
	public static ObjectReservation getObjectReservation(){
		if(null==object){
			object=new ObjectReservation();
		}
		return object;
		
	}
	
	public void setObjectMap(Map map){
		this.objectMap=map;
	}
	
	public Map<String,String> getObjectMap(){
		return objectMap;
	}
}
