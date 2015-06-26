package net.shop.manager.dao;

import java.util.List;

import net.shop.manager.domain.Discounts;

public interface DiscountsDAO {
	
	public void newDiscount(Discounts discount);
	
	public Discounts getDiscount();
	
	public List<Discounts> getAllDiscounts();
	
	public void updateDiscount(Discounts discount);
}
