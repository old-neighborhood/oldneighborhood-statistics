package com.oldneighborhood.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
/**
 * @ClassName: ParkingLot  
 * @Description: 停车位实时统计
 * @author user005  
 * @date 2018年4月4日  
 */
@Entity
@Table(name="parkinglot_data")
@Data
public class ParkingLot implements Serializable{
	private static final long serialVersionUID = 833945599575420110L;
	
	private String pl_ID;
	private Integer site_ID;
	private Timestamp pl_now;
	private int pl_amount;
	private int pl_available;
	
	public ParkingLot(Integer site_ID, Timestamp pl_now, int pl_amount, int pl_available) {
		super();
		this.site_ID = site_ID;
		this.pl_now = pl_now;
		this.pl_amount = pl_amount;
		this.pl_available = pl_available;
	}
	
	
}
