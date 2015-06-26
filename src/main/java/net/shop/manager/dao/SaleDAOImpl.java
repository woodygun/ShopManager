package net.shop.manager.dao;

import java.util.List;

import net.shop.manager.domain.Sale;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SaleDAOImpl implements SaleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addSale(Sale sale) {
		sessionFactory.getCurrentSession().save(sale);
	}

	@SuppressWarnings("unchecked")
	public List<Sale> listSale() {
		return sessionFactory.getCurrentSession().createQuery("from Sale")
	            .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> saleByGoodsId(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("from Sale WHERE id_goods="+id)
	            .list();
	}

}
