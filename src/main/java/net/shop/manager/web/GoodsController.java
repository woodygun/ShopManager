package net.shop.manager.web;

import java.util.List;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodsController {
	 	@Autowired
	    private GoodsService goodsService;
	    @Autowired
	    private SaleService saleService;
	    @Autowired
	    private DiscountsService discountsService;
	    
	    private int pageGoods=1;
		private Discounts discountsNow;
	    
	    @RequestMapping("/index")
	    public String listContacts(Map<String, Object> map) {
	        return "redirect:/Goods";
	    }
	    
	    
	    @RequestMapping(value ="/Goods")
	    public String listGoods(Map<String, Object> map) {
	    	
	    	discountsNow=discountsService.getDiscounts();
	    	pageGoods = pageGoods < 1 ? 1 : pageGoods;   	
	    	if(discountsNow!=null)
	        {
	    	map.put("DiscountsGoodsName", goodsService.getGoodsByID(discountsNow.getIdGoods()).getNomination());
	    	map.put("DiscountsAmount",discountsNow.getDiscountAmount());
	    	map.put("DiscountsDate",discountsNow.getPricesEnd());
	        }
	    	map.put("goods", new Goods());
	        map.put("goodsList", goodsService.listGoodsForPage(pageGoods));
	        map.put("maxPages",goodsService.pageCount());
	        
	        return "Goods";
	    }
	    //Выводит информацию о продажах товара
	    @RequestMapping("/Goods{goodsId}")
	    public String goodsSaleInfo(@PathVariable("goodsId") Integer goodsId,
	    							Map<String, Object> map) {
	    	
	    	pageGoods = pageGoods < 1 ? 1 : pageGoods;
	        map.put("goods", new Goods());
	        map.put("goodsList", goodsService.listGoodsForPage(pageGoods));
	        map.put("maxPages",goodsService.pageCount());
	        map.put("saleGoodsList",saleService.saleByGoodsId(goodsId));
	        map.put("goodsInfoList",goodsService.getGoodsByID(goodsId).getNomination());
	        
	        discountsNow=discountsService.getDiscounts();
	        if(discountsNow!=null)
	        {
	        map.put("DiscountsGoodsName", goodsService.getGoodsByID(discountsNow.getIdGoods()).getNomination());
	    	map.put("DiscountsAmount",discountsNow.getDiscountAmount());
	    	map.put("DiscountsDate",discountsNow.getPricesEnd());
	        }
	        
	    	return "Goods";
	    }
	    
	    @RequestMapping("/")
	    public String home() {
	    	 return "redirect:/Goods";
	    }
	    
	    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
	    public String addGoods(@ModelAttribute("viewdata") ViewData newViewData,
	            BindingResult result) 
	    {
	    	if(newViewData.getNomination()!= "" && newViewData.getPrice()!= null)
	    	{
	    	Goods newGoods=newViewData.getNewGoods();
	    	
	    	for(Goods oldGoods:goodsService.listGoods())
	    	{
	    		if(newGoods.getNomination().equals(oldGoods.getNomination()))
	    			return "redirect:/Goods";
	    	}
	    	goodsService.addGoods(newGoods);
	    	}
	        return "redirect:/Goods";
	    }
	   
	    @RequestMapping("/deleteGoods/{goodsId}")
	    public String deleteGoods(@PathVariable("goodsId") Integer goodsId) {
	    	if(goodsService.getGoodsByID(goodsId)!=null)//
	    		goodsService.removeGoods(goodsId);
	        
	        return "redirect:/Goods";
	    }
	    
	    @RequestMapping(value = "/updateGoods/{goodsId}", method = RequestMethod.POST)
	    public String updateGoods(@PathVariable("goodsId") Integer goodsId,
	    							@ModelAttribute("viewdata") ViewData newViewData,
	    							BindingResult result){
	    	if(goodsService.getGoodsByID(goodsId)!=null && newViewData.getNomination()!="" //
	    			&& newViewData.getPrice()>0)
	    		goodsService.updateGoods(newViewData.getGoodsForUpdate(goodsId));
	        
	        return "redirect:/Goods";
	    }

	    @RequestMapping(value ="/GoodsPage",method = RequestMethod.GET)
	    public String pageGoods(@RequestParam(value = "page", required = false) Integer page){//,
	        page = page == null ? 1 : page;
	        pageGoods=page;
	        return "redirect:/Goods";
	    }
}
