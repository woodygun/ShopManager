package net.shop.manager.web;

import java.util.Map;

import net.shop.manager.domain.Goods;
import net.shop.manager.service.DiscountsService;
import net.shop.manager.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiscountsController {
	
	@Autowired
    private DiscountsService discountsService;
 	@Autowired
    private GoodsService goodsService;
	
	@RequestMapping(value ="/Discounts")    
	public String listDiscounts(Map<String, Object> map) {
		
		map.put("DiscountsHistoryList", discountsService.getAllDiscounts());
		map.put("goodsAllList", goodsService.listAllGoods());
		
		return "Discounts";
	}
}
