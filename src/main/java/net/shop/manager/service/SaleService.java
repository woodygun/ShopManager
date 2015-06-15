package net.shop.manager.service;

import java.util.List;

import net.shop.manager.domain.Sale;

public interface SaleService {

	public void addSale(Sale sale);
	
	public List<Sale> listSale();
	
	public List<Sale> SaleByGoodsId(Integer id);
	
}
