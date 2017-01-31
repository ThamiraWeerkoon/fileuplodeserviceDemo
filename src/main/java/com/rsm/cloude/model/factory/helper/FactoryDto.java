package com.rsm.cloude.model.factory.helper;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FactoryDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String ticker;
	private Integer factoryId;
	private String address;
	private String state;
	private long zip;
	private double latitude;
	private double longtitude;
	private String matchID;
	private String name;
	private String directory;
	
	// This fields are optional
	private int spaces;
	private int cars;
	private String comment;
	private int sideCarParks;
	private String mallType;	
	private String status;
	
	// Extra
	private Date date;
	private Date time;

}
