package com.oldneighborhood.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
/**
 * @ClassName: Flow  
 * @Description: 统计日流量 
 * @author user005  
 * @date 2018年4月4日  
 */
@Entity
@Table(name="flow_data")
@Data
public class Flow implements Serializable{
	private static final long serialVersionUID = -8513420741491188780L;
	
	private String flow_ID;
	private Integer site_ID;
	private Date flow_date;
	private int flow_amount;
	private String flow_class;
	
	public Flow(Integer site_ID, Date flow_date, int flow_amount, String flow_class) {
		super();
		this.site_ID = site_ID;
		this.flow_date = flow_date;
		this.flow_amount = flow_amount;
		this.flow_class = flow_class;
	}
}
