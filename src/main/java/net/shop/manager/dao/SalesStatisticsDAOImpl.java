package net.shop.manager.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.shop.manager.domain.SalesStatistics;

@Repository
public class SalesStatisticsDAOImpl implements SalesStatisticsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addStatistics(SalesStatistics salesStatistics) {
		sessionFactory.getCurrentSession().save(salesStatistics);
	}

	
	@SuppressWarnings("unchecked")
	public List<SalesStatistics> getStatistics() {
		return sessionFactory.getCurrentSession().createCriteria(SalesStatistics.class).list();
	}

}
