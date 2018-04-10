package com.oldneighborhood.demo.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oldneighborhood.demo.entity.Flow;
import com.oldneighborhood.demo.entity.FlowNow;
import com.oldneighborhood.demo.entity.ParkingLot;
import com.oldneighborhood.demo.entity.Ticket;
import com.oldneighborhood.demo.service.StatisticsService;

import net.sf.json.JSONObject;

/**
 * @ClassName: StatisticsServiceImpl
 * @Description:
 * 1.历史数据直接从数据库中取出展示
 * 2.实时数据通过API获取（获取失败，则从数据库最近的一次数据中读取）
 * 3.每隔一小时从API读取人流量数据存入数据库中，每隔十分钟读取停车场数据存入数据库中，每天统计票务存入数据库中
 * @author user005
 * @date 2018年4月10日
 */
@Service
public class StatisticsServiceImpl implements StatisticsService{
	
	//public调用controller 获取url(已经拼接后url)
	private static String urlPL;
	private static String urlTicket;
	private static String urlFlow;
	RestTemplate rs = new RestTemplate();
	
	@Override
	public ParkingLot parkLotData(Map<String, Object> map) {
		String res = rs.getForObject(urlPL, String.class);
		JSONObject js = JSONObject.fromObject(res);
		ParkingLot pl = new ParkingLot(
				js.getInt(""), 
				Timestamp.valueOf(js.getString("")), 
				js.getInt(""), js.getInt(""));
		return pl;
	}

	@Override
	public Ticket ticketData(Map<String, Object> map) throws ParseException {
		String res = rs.getForObject(urlTicket, String.class);
		JSONObject js = JSONObject.fromObject(res);
		Ticket ticket = new Ticket(
				js.getInt(""), 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(js.getString("")), 
				js.getInt(""), 
				js.getInt(""));
		return ticket;
	}
	
	

	@Override
	public Flow flowData(Map<String, Object> map) throws ParseException {
		String res = rs.getForObject(urlFlow, String.class);
		JSONObject js = JSONObject.fromObject(res);
		Flow flow = new Flow(
				js.getInt(""), 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(js.getString("")), 
				js.getInt(""));
		return flow;
	}

	@Override
	public FlowNow realFlow(Map<String, Object> map) {
		String res = rs.getForObject(urlFlow, String.class);
		JSONObject js = JSONObject.fromObject(res);
		FlowNow realflow = new FlowNow(
				js.getInt(""), 
				Timestamp.valueOf(js.getString("")),
				js.getInt(""));
		return realflow;
	}

}
