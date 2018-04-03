package com.oldneighborhood.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	
	//要不要支持文件导入
	@RequestMapping("/history")
	public String historyData() {
		return "";
	}
	
	//创建新的API接口
	@RequestMapping("/new")
	public String newInterface() {
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
	//预测计算
	@RequestMapping("/future")
	public String futureData() {
		return "";
	}

}
