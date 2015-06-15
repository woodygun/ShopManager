package net.shop.manager.dao;

import java.util.List;
import net.shop.manager.domain.Sale;

public interface SaleDAO {
	
	public void addSale(Sale sale);
	
	public List<Sale> listSale();
	
	public List<Sale> SaleByGoodsId(Integer id);
}

