package net.shop.manager.service;

import java.util.Date;
import java.util.List;

import net.shop.manager.domain.Sale;
import net.shop.manager.domain.SalesStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

public class StatisticsScheduler {

	@Autowired
	SaleService saleService;
	
	@Autowired
	SalesStatisticsService saleStatisticsService;
	
	SalesStatistics salesStatistics;
	Date startDate;
	Date endDate;
	Long time;
	
	public void newSalesStatistics()
	{
		endDate = new Date();
		time = endDate.getTime()-1000*60*60;
		startDate = new Date(time);
		
		salesStatistics=new SalesStatistics();
		salesStatistics.setSalesStart(startDate);
		salesStatistics.setSalesEnd(endDate);
		
		saleStatisticsService.addStatistics(salesStatistics);
	}
	
}
