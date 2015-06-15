package net.shop.manager.dao;

import java.util.List;

import net.shop.manager.domain.Goods;

public interface GoodsDAO {

	public void addGoods(Goods good);

    public List<Goods> listGoods();
    
    public List<Goods> listAllGoods();

    public void removeGoods(Integer id);
    
    public void UpdateGoods(Goods good);
    
    public Goods GetGoodsByID(Integer id);
    
    public int PageCount();
    
    public List<Goods> listGoodsForPage(Integer page_number);
    
}