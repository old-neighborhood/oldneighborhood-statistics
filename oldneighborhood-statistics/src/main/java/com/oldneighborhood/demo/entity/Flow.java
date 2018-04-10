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
	//有没有人流量等级的规定？
	public Flow(Integer site_ID, Date flow_date, int flow_amount) {
		super();
		this.site_ID = site_ID;
		this.flow_date = flow_date;
		this.flow_amount = flow_amount;
		if (flow_amount > 100000) {
			this.flow_class = "5";
		}else if (flow_amount > 10000) {
			this.flow_class = "4";
		}else if (flow_amount > 1000) {
			this.flow_class = "3";
		}else if (flow_amount > 100) {
			this.flow_class = "2";
		}else {
			this.flow_class = "1";
		}
	}
}
