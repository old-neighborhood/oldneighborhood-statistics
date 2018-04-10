package com.oldneighborhood.demo.service;

import java.text.ParseException;
import java.util.Map;

import com.oldneighborhood.demo.entity.Flow;
import com.oldneighborhood.demo.entity.FlowNow;
import com.oldneighborhood.demo.entity.ParkingLot;
import com.oldneighborhood.demo.entity.Ticket;

public interface StatisticsService {
	
	public ParkingLot parkLotData(Map<String, Object> map);
	
	public Ticket ticketData(Map<String, Object> map) throws ParseException;
	
	//默认 /日流量date a->b / 某天date
	public Flow flowData(Map<String, Object> map) throws ParseException;
	
	public FlowNow realFlow(Map<String, Object> map);
}
