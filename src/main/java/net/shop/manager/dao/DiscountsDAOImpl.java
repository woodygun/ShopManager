package net.shop.manager.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;

import net.shop.manager.domain.Discounts;
import net.shop.manager.domain.Goods;

public class DiscountsDAOImpl implements DiscountsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void endDiscount() {

	}

	@Override
	public void newDiscount() {
		
	}

	@Override
	public Discounts getDiscount() {
		return (Discounts)sessionFactory.getCurrentSession().
				 createQuery("from Discounts WHERE status=\"active\"").uniqueResult();	
	}

	@Override
	public List<Discounts> getAllDiscounts() {
		return sessionFactory.getCurrentSession().createCriteria(Discounts.class).list();	
	}

}
