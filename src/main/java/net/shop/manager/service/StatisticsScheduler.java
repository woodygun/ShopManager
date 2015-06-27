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

	List<Sale> sales;
	
	public void newSalesStatistics()
	{
		Date endDate = new Date();
		Long time = endDate.getTime()-1000*60*5;
		Date startDate = new Date(time);
		
		sales=saleService.getSaleByDate(startDate, endDate);
		
		if(sales.size()>0){

			salesStatistics=new SalesStatistics();
			salesStatistics.setSalesStart(startDate);
			salesStatistics.setSalesEnd(endDate);
			salesStatistics.setAmount(sales.size());
			
			float ChecksTotalValue=0;
			float DiscountsChecksTotalValue=0;
			for(Sale sale:sales)
			{
				ChecksTotalValue+=sale.getPrice();
				DiscountsChecksTotalValue+=sale.getDiscountPrice();
			}
			salesStatistics.setChecksTotalValue(ChecksTotalValue);
			salesStatistics.setChecksAverageValue(ChecksTotalValue/sales.size());
			
			salesStatistics.setAmountOfDiscounts(ChecksTotalValue-DiscountsChecksTotalValue);
			
			salesStatistics.setChecksDiscountsTotalValue(DiscountsChecksTotalValue);
			salesStatistics.setChecksDiscountsAverageValue(DiscountsChecksTotalValue/sales.size());
		
			saleStatisticsService.addStatistics(salesStatistics);
		}
	}
	
}
