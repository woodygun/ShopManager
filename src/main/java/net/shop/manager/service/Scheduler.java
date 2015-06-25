package net.shop.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import net.shop.manager.domain.Discounts;
import net.shop.manager.domain.Goods;

import org.springframework.scheduling.annotation.Scheduled;

public class Scheduler {
	Discounts discount;
	DiscountsService discountsService;
	GoodsService goodsService;
	Random random = new Random();
	List<Goods> goods;
	
	@Scheduled(fixedDelay = 1000)
    public void createDiscount() {
		Date startDate = new Date();
		Long time = startDate.getTime()+60*60;
		Date endDate = new Date(time);
		
		goods=goodsService.listGoods();
		
		int goodsId=goods.get(random.nextInt(goods.size())).getId();
		
		discount=new Discounts();
		discount.setDiscountAmount(random.nextInt(6)+4);
		discount.setIdGoods(goodsId);
		discount.setPricesStart(startDate);
		discount.setPricesEnd(endDate);
		discount.setStatus("true");
		
		discountsService.newDiscounts(discount);
		
    }
}
