package net.shop.manager.dao;

import java.util.List;

import net.shop.manager.domain.SalesStatistics;

public interface SalesStatisticsDAO {
	public void addStatistics(SalesStatistics salesStatistics);
	
	public List<SalesStatistics> getStatistics();
}
