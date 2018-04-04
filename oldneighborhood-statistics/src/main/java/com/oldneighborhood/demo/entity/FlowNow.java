package com.oldneighborhood.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
/**
 * @ClassName: FlowNow  
 * @Description: 实时人流量
 * @author user005  
 * @date 2018年4月4日  
 */
@Entity
@Table(name="real_flow")
@Data
public class FlowNow implements Serializable{
	private static final long serialVersionUID = -1904203439826898890L;
	
	private String flow_ID;
	private Integer site_ID;
	private Timestamp flow_now;
	private int flow_amount;
	private String flow_class;
	
	public FlowNow(Integer site_ID, Timestamp flow_now, int flow_amount, String flow_class) {
		super();
		this.site_ID = site_ID;
		this.flow_now = flow_now;
		this.flow_amount = flow_amount;
		this.flow_class = flow_class;
	}
}
