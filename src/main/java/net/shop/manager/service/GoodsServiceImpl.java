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
    	goodsDAO.updateGoods(goods);
	}

    @Transactional
    public Goods getGoodsByID(Integer id){
    	return goodsDAO.getGoodsByID(id);
    }
    
    @Transactional
    public int pageCount()
    {
    	return goodsDAO.pageCount();
    }
    
    @Transactional
    public List<Goods> listGoodsForPage(Integer pageNumber)
    {
    	return goodsDAO.listGoodsForPage(pageNumber);
    }

}
