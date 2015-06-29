package net.shop.manager.web;

import java.util.Map;

import net.shop.manager.domain.Discounts;
import net.shop.manager.domain.Goods;
import net.shop.manager.domain.Sale;
import net.shop.manager.domain.ViewData;
import net.shop.manager.service.DiscountsService;
import net.shop.manager.service.GoodsService;
import net.shop.manager.service.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaleController {

 	@Autowired
    private GoodsService goodsService;
    @Autowired
    private SaleService saleService;
    @Autowired
    private DiscountsService discountsService;
    
	private Discounts discountsNow;
    
	@RequestMapping("/Sale")
    public String listSale(Map<String, Object> map) {

	    map.put("sale", new Sale());
	    map.put("saleList", saleService.listSale());
		
    	map.put("goods", new Goods());
        map.put("goodsAllList", goodsService.listAllGoods());
        map.put("goodsList", goodsService.listGoods());       
        map.put("goods_nomination", "");
        map.put("goods_price", "");
        
        discountsNow=discountsService.getDiscounts(); 	
    	if(discountsNow!=null)
        {
    	map.put("DiscountsGoodsName", goodsService.getGoodsByID(discountsNow.getIdGoods()).getNomination());
    	map.put("DiscountsAmount",discountsNow.getDiscountAmount());
    	map.put("DiscountsDate",discountsNow.getPricesEnd());
        }
        
        return "Sale";
    }
	
	//Информация о товаре
    @RequestMapping("/Sale{goodsId}")
    public String saleGoodsInfo(@PathVariable("goodsId") Integer goodsId,
    		Map<String, Object> map) {
    	
    	map.put("goods", new Goods());
        map.put("goodsAllList", goodsService.listAllGoods());
        map.put("goodsList", goodsService.listGoods());
        map.put("sale", new Sale());
        map.put("saleList", saleService.listSale());
        map.put("goods_nomination", goodsService.getGoodsByID(goodsId).getNomination());
        map.put("goods_price", goodsService.getGoodsByID(goodsId).getPrice().toString());        
        
        discountsNow=discountsService.getDiscounts(); 	
    	if(discountsNow!=null)
        {
    	map.put("DiscountsGoodsName", goodsService.getGoodsByID(discountsNow.getIdGoods()).getNomination());
    	map.put("DiscountsAmount",discountsNow.getDiscountAmount());
    	map.put("DiscountsDate",discountsNow.getPricesEnd());
        }
    	
        return "Sale";
    }
    
    @RequestMapping(value = "/addSale", method = RequestMethod.POST)
    public String addSale(@ModelAttribute("viewdata") ViewData newViewData,
            BindingResult result) {
    	Float salePrice;
    	
    	if(newViewData.getAmount()!=null && goodsService.getGoodsByID(newViewData.getIdGoods())!=null)
    	{
    	Sale newSale=newViewData.getNewSale();
    	
    	salePrice=goodsService.getGoodsByID(newSale.getIdGoods()).
        		getPrice()*newSale.getAmount();
        
    	newSale.setPrice(salePrice);
    	
    	discountsNow=discountsService.getDiscounts(); 
    	if(discountsNow!=null)
    		if(newViewData.getIdGoods().equals(discountsService.getDiscounts().getIdGoods()))
    		{
    			salePrice-=salePrice/100*discountsService.getDiscounts().getDiscountAmount();
    			newSale.setDiscount(discountsService.getDiscounts().getDiscountAmount().toString());
    		}
    		
    	newSale.setDiscountPrice(salePrice);
    	
    	saleService.addSale(newSale);
    	}
        return "redirect:/Sale";
    }
}
