package net.shop.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.manager.dao.SalesStatisticsDAO;
import net.shop.manager.domain.SalesStatistics;

@Service
public class SalesStatisticsServiceImpl implements SalesStatisticsService {

	@Autowired
	private SalesStatisticsDAO salesStatisticsDAO;
	
	@Transactional
	public void addStatistics(SalesStatistics salesStatistics) {
		salesStatisticsDAO.addStatistics(salesStatistics);
	}

	@Transactional
	public List<SalesStatistics> getStatistics() {
		return salesStatisticsDAO.getStatistics();
	}

}
