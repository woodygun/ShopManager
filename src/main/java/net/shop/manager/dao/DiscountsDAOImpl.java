package net.shop.manager.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.shop.manager.domain.Discounts;
import net.shop.manager.domain.Goods;

@Repository
public class DiscountsDAOImpl implements DiscountsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void newDiscount(Discounts discount) {
		sessionFactory.getCurrentSession().save(discount);
	}


	public Discounts getDiscount() {	
		return (Discounts) sessionFactory.getCurrentSession().createCriteria(Discounts.class)
				.add(Expression.eq("status","true"))
				.uniqueResult();
	}


	public List<Discounts> getAllDiscounts() {
		return sessionFactory.getCurrentSession().createCriteria(Discounts.class).list();	
	}
	
	public void updateDiscount(Discounts discount)
	{ 
        sessionFactory.getCurrentSession().update(discount);
	}

}
