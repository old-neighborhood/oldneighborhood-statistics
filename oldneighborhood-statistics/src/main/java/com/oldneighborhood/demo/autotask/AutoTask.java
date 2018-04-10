package com.oldneighborhood.demo.autotask;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.oldneighborhood.demo.dao.FlowDao;
import com.oldneighborhood.demo.dao.FlowNowDao;
import com.oldneighborhood.demo.dao.ParkingLotDao;
import com.oldneighborhood.demo.dao.TicketDao;
import com.oldneighborhood.demo.entity.Flow;
import com.oldneighborhood.demo.entity.FlowNow;
import com.oldneighborhood.demo.entity.ParkingLot;
import com.oldneighborhood.demo.entity.Ticket;
import com.oldneighborhood.demo.service.StatisticsService;

//可視化暫時不考慮
/**
 * @ClassName: AutoTask
 * @Description: 自动收集数据进行持久化
 * @author user005
 * @date 2018年4月10日
 */
@Component
public class AutoTask {
	
	@Autowired
	private StatisticsService statisticsService;
	//用于获取数据
	
	@Autowired
	private FlowDao flowDao;
	@Autowired
	private FlowNowDao flowNowDao;
	@Autowired
	private ParkingLotDao parkingLotDao;
	@Autowired
	private TicketDao ticketDao;
	
	//从6:00到22:00每分钟运行一次
	@Scheduled(cron = "0 0/1 6-22 * * ?")
	public String parkingLotData() {
		Map<String, Object> map = null;
		try {
			ParkingLot pl = statisticsService.parkLotData(map);
			parkingLotDao.save(pl);
			return "{\"result\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}
	//从6:00到22:00每半小时运行一次
	@Scheduled(cron = "0 0/30 6-22 * * ?")
	public String RealFlowData() {
		Map<String, Object> map = null;
		try {
			FlowNow realflow = statisticsService.realFlow(map);
			flowNowDao.save(realflow);
			return "{\"result\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}
	
	@Scheduled(cron = "0 59 23 * * ?")
	public String FlowData() {
		Map<String, Object> map = null;
		try {
			Flow flow = statisticsService.flowData(map);
			flowDao.save(flow);
			return "{\"result\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}
	//每天23:59运行
	@Scheduled(cron = "0 59 23 * * ?")
	public String TicketData() {
		Map<String, Object> map = null;
		try {
			Ticket ticket = statisticsService.ticketData(map);
			ticketDao.save(ticket);
			return "{\"result\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}

}
