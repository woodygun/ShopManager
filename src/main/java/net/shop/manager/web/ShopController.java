package net.shop.manager.web;

import java.util.List;
import java.util.Map;

import net.shop.manager.domain.Goods;
import net.shop.manager.domain.Sale;
import net.shop.manager.domain.ViewData;
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
public class ShopController {
	 	@Autowired
	    private GoodsService goodsService;
	    @Autowired
	    private SaleService saleService;
	    
	    private int pageGoods=1;
		
	    @RequestMapping("/index")
	    public String listContacts(Map<String, Object> map) {
	        return "redirect:/Goods";
	    }
	    
	    
	    @RequestMapping(value ="/Goods")
	    public String listGoods(Map<String, Object> map) {
	    	pageGoods = pageGoods < 1 ? 1 : pageGoods;   	
	        map.put("goods", new Goods());
	        map.put("goodsList", goodsService.listGoodsForPage(pageGoods));
	        map.put("maxPages",goodsService.PageCount());
	        
	        return "Goods";
	    }
	    //Выводит информацию о продажах товара
	    @RequestMapping("/Goods{GoodsId}")
	    public String GoodsSaleInfo(@PathVariable("GoodsId") Integer GoodsId,
	    							Map<String, Object> map) {
	    	
	    	pageGoods = pageGoods < 1 ? 1 : pageGoods;
	        map.put("goods", new Goods());
	        map.put("goodsList", goodsService.listGoodsForPage(pageGoods));
	        map.put("maxPages",goodsService.PageCount());
	        map.put("saleGoodsList",saleService.SaleByGoodsId(GoodsId));
	        map.put("goodsInfoList",goodsService.GetGoodsByID(GoodsId).getnomination());
	        
	        return "Goods";
	    }
	    
	    @RequestMapping("/Sale")
	    public String listSale(Map<String, Object> map) {

	    	map.put("goods", new Goods());
	        map.put("goodsAllList", goodsService.listAllGoods());
	        map.put("goodsList", goodsService.listGoods());
	        map.put("sale", new Sale());
	        map.put("saleList", saleService.listSale());
	        map.put("goods_nomination", "");
	        map.put("goods_price", "");
	        
	        return "Sale";
	    }
	    
	    //Информация о товаре
	    @RequestMapping("/Sale{GoodsId}")
	    public String SaleGoodsInfo(@PathVariable("GoodsId") Integer GoodsId,
	    		Map<String, Object> map) {
	    	map.put("goods", new Goods());
	        map.put("goodsAllList", goodsService.listAllGoods());
	        map.put("goodsList", goodsService.listGoods());
	        map.put("sale", new Sale());
	        map.put("saleList", saleService.listSale());
	        map.put("goods_nomination", goodsService.GetGoodsByID(GoodsId).getnomination());
	        map.put("goods_price", goodsService.GetGoodsByID(GoodsId).getprice().toString());        
	        return "Sale";
	    }
	    
	    @RequestMapping("/")
	    public String home() {
	    	 return "redirect:/Goods";
	    }
	    
	    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
	    public String addGoods(@ModelAttribute("viewdata") ViewData NewVD,
	            BindingResult result) 
	    {
	    	if(NewVD.getNomination()!= "" && NewVD.getPrice()!= null)
	    	{
	    	Goods Newgoods=NewVD.getNewGoods();
	    	
	    	for(Goods Oldgoods:goodsService.listGoods())
	    	{
	    		if(Newgoods.getnomination().equals(Oldgoods.getnomination()))
	    			return "redirect:/Goods";
	    	}
	    	goodsService.addGoods(Newgoods);
	    	}
	        return "redirect:/Goods";
	    }

	    @RequestMapping(value = "/addSale", method = RequestMethod.POST)
	    public String addSale(@ModelAttribute("viewdata") ViewData NewVD,
	            BindingResult result) {
	    	
	    	if(NewVD.getAmount()!=null && goodsService.GetGoodsByID(NewVD.getId_goods())!=null)
	    	{
	    	Sale NewSale=NewVD.getNewSale();
	    	
	        NewSale.setprice(goodsService.GetGoodsByID(NewSale.getid_goods()).
	        		getprice()*NewSale.getamount());
	    	
	    	saleService.addSale(NewSale);
	    	}
	        return "redirect:/Sale";
	    }
	   
	    @RequestMapping("/deleteGoods/{GoodsId}")
	    public String deleteGoods(@PathVariable("GoodsId") Integer GoodsId) {
	    	if(goodsService.GetGoodsByID(GoodsId)!=null)//
	    		goodsService.removeGoods(GoodsId);
	        
	        return "redirect:/Goods";
	    }
	    
	    @RequestMapping(value = "/updateGoods/{GoodsId}", method = RequestMethod.POST)
	    public String updateGoods(@PathVariable("GoodsId") Integer GoodsId,
	    							@ModelAttribute("viewdata") ViewData NewVD,
	    							BindingResult result){
	    	if(goodsService.GetGoodsByID(GoodsId)!=null && NewVD.getNomination()!="" //
	    			&& NewVD.getPrice()>0)
	    		goodsService.updateGoods(NewVD.getGoodsForUpdate(GoodsId));
	        
	        return "redirect:/Goods";
	    }

	    @RequestMapping(value ="/GoodsPage",method = RequestMethod.GET)
	    public String pageGoods(@RequestParam(value = "page", required = false) Integer page){//,
	        page = page == null ? 1 : page;
	        pageGoods=page;
	        return "redirect:/Goods";
	    }
}
