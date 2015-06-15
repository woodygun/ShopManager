package net.shop.manager.dao;

import java.util.List;

import net.shop.manager.domain.Discounts;

public interface DiscountsDAO {
	
	public void endDiscount();
	
	public void newDiscount();
	
	public Discounts getDiscount();
	
	public List<Discounts> getAllDiscounts();
}
