package com.oldneighborhood.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="api_data")
@Data
@AllArgsConstructor
public class API implements Serializable{
	private static final long serialVersionUID = 7110320250595595442L;
	
	private String api_ID;
	private String api_name;
	private String api_url;
	//Map<String, Object>格式->JSON
	private String api_reqMap;
	private String api_resMap;
	//新建api实体
	public API(String api_name, String url, String reqMap, String resMap) {
		super();
		this.api_name = api_name;
		this.api_url = url;
		this.api_reqMap = reqMap;
		this.api_resMap = resMap;
	}
}
