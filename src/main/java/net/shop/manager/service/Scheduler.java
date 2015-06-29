package net.shop.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import net.shop.manager.domain.Discounts;
import net.shop.manager.domain.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

public class Scheduler {
	
	Discounts discount;
	
	@Autowired
	DiscountsService discountsService;
	
	@Autowired
	GoodsService goodsService;
	
	private Discounts discountsNow;
	
	Random random = new Random();
	List<Goods> goods;
	List<Discounts> discountsList;
	
    public void createDiscount() {
    	
    	discountsNow=discountsService.getDiscounts();
    	
    	goods=goodsService.listGoods();
		if(goods!=null){
    	
    	finishAllDiscounts();
    	
		Date startDate = new Date();
		Long time = startDate.getTime()+1000*60*5;
		Date endDate = new Date(time);
		
		if(discountsNow.getPricesEnd().getTime()<startDate.getTime()){
		
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
    }
    
    private void finishAllDiscounts()
    {
    	discountsList=discountsService.getAllDiscounts();
    	
    	for(Discounts discount:discountsList)
    	{
    		if(discount.getStatus()!="false")
    		{
    			discount.setStatus("false");
    			discountsService.updateDiscount(discount);
    		}
    	}
    }
}
