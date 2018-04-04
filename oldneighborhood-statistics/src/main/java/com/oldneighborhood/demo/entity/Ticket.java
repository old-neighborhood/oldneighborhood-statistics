package com.oldneighborhood.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
/**
 * @ClassName: Ticket  
 * @Description: 票务统计/日
 * @author user005  
 * @date 2018年4月4日  
 */
@Entity
@Table(name="ticket_data")
@Data
public class Ticket implements Serializable{
	private static final long serialVersionUID = -5606528162433653334L;
	
	private String ticket_ID;
	private Integer site_ID;
	private Date ticket_date;
	private int ticket_online;
	private int ticket_offline;
	private int ticket_amount;
	
	public Ticket(Integer site_ID, Date ticket_date, int ticket_online, int ticket_offline) {
		super();
		this.site_ID = site_ID;
		this.ticket_date = ticket_date;
		this.ticket_online = ticket_online;
		this.ticket_offline = ticket_offline;
		this.ticket_amount = ticket_offline + ticket_online;
	}
	
	
	
	
}
