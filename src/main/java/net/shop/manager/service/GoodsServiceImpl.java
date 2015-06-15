package net.shop.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.manager.dao.GoodsDAO;
import net.shop.manager.domain.Goods;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;
    
    @Transactional
	public void addGoods(Goods goods) {
    	goodsDAO.addGoods(goods);	
	}

    @Transactional
	public List<Goods> listGoods() {
    	return goodsDAO.listGoods();
	}
    
    @Transactional
	public List<Goods> listAllGoods() {
    	return goodsDAO.listAllGoods();
	}

    @Transactional
	public void removeGoods(Integer id) {
    	goodsDAO.removeGoods(id);	
	}

    @Transactional
	public void updateGoods(Goods goods) {
    	goodsDAO.UpdateGoods(goods);
	}

    @Transactional
    public Goods GetGoodsByID(Integer id){
    	return goodsDAO.GetGoodsByID(id);
    }
    
    @Transactional
    public int PageCount()
    {
    	return goodsDAO.PageCount();
    }
    
    @Transactional
    public List<Goods> listGoodsForPage(Integer page_number)
    {
    	return goodsDAO.listGoodsForPage(page_number);
    }

}
