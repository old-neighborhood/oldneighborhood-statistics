package com.oldneighborhood.demo.service;

import java.util.Date;

public interface StatisticsService {
	
	public String HistoryData();
	
	public String parkLotData();
	
	public String dataDisplay();
	
	//默认
	public String flowData();
	//日流量
	public String flowData(Date dateon, Date dateoff);
	//某天
	public String flowData(Date date);
	
}
