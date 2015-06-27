package net.shop.manager.service;

import java.util.List;

import net.shop.manager.domain.SalesStatistics;

public interface SalesStatisticsService {
	public void addStatistics(SalesStatistics salesStatistics);
	
	public List<SalesStatistics> getStatistics();
}
