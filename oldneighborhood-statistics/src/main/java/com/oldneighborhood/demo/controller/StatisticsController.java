package com.oldneighborhood.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	
	//历史数据导入
	@RequestMapping("/history")
	public String historyData() {
		return "";
	}
	
	@RequestMapping("/display")
	public String dataDisplay() {
		return "";
	}
	
	//停车场车流量
	@RequestMapping("/parkinglot")
	public String parkLotData() {
		return "";
	}
	//人流量
	@RequestMapping("/crowd") 
	public String crowdData() {
		return "";
	}
	//票务
	@RequestMapping("/ticket")
	public String ticketData() {
		return "";
	}
	
}
