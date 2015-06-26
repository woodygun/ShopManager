package net.shop.manager.web;

import java.util.Map;

import net.shop.manager.domain.Goods;
import net.shop.manager.service.DiscountsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiscountsController {
	
	@Autowired
    private DiscountsService discountsService;
	
	@RequestMapping(value ="/Discounts")    
	public String listDiscounts(Map<String, Object> map) {
		
		map.put("DiscountsHistoryList", discountsService.getAllDiscounts());
		
		return "Discounts";
	}
}
