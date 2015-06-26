package net.shop.manager.service;

import java.util.List;

import net.shop.manager.domain.Discounts;

public interface DiscountsService {

	public void endDiscounts();
	
	public void newDiscounts(Discounts discount);
	
	public Discounts getDiscounts();
	
	public List<Discounts> getAllDiscounts();
	
	public void updateDiscount(Discounts discount);
}
