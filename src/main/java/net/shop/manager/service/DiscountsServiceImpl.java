package net.shop.manager.service;

import java.util.List;

import net.shop.manager.dao.DiscountsDAO;
import net.shop.manager.domain.Discounts;
import net.shop.manager.domain.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscountsServiceImpl implements DiscountsService {

	@Autowired
    private DiscountsDAO discountsDAO;
	
    @Transactional
	public void endDiscounts() {
    	discountsDAO.endDiscount();
	}

    @Transactional
	public void newDiscounts(Discounts discount) {
    	discountsDAO.newDiscount(discount);
	}

    @Transactional
	public Discounts getDiscounts() {
    	return discountsDAO.getDiscount();
	}

    @Transactional
	public List<Discounts> getAllDiscounts() {
    	return discountsDAO.getAllDiscounts();		
	}

}
