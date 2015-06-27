package net.shop.manager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.manager.dao.SaleDAO;
import net.shop.manager.domain.Sale;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDAO saleDAO;
    
    @Transactional
	public void addSale(Sale sale) {
    	saleDAO.addSale(sale);		
	}

    @Transactional
	public List<Sale> listSale() {
		return saleDAO.listSale();
	}

    @Transactional
	public List<Sale> saleByGoodsId(Integer id) {
		return saleDAO.saleByGoodsId(id);
	}

    @Transactional
    public List<Sale> getSaleByDate(Date startDate,Date endDate){
    	return saleDAO.getSaleByDate(startDate, endDate);
    }
}
