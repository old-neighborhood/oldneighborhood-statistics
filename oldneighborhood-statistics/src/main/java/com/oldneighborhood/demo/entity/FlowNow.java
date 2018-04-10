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
	
	private String now_ID;
	private Integer site_ID;
	private Timestamp now_flow;
	private int now_amount;
	private String now_class;
	
	public FlowNow(Integer site_ID, Timestamp now_flow, int now_amount) {
		super();
		this.site_ID = site_ID;
		this.now_flow = now_flow;
		this.now_amount = now_amount;
		if (now_amount > 100000) {
			this.now_class = "5";
		}else if (now_amount > 10000) {
			this.now_class = "4";
		}else if (now_amount > 1000) {
			this.now_class = "3";
		}else if (now_amount > 100) {
			this.now_class = "2";
		}else {
			this.now_class = "1";
		}
	}
}
