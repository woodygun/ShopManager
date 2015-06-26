package net.shop.manager.dao;

import java.util.List;

import net.shop.manager.domain.Goods;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAOImpl implements GoodsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addGoods(Goods goods) {
		sessionFactory.getCurrentSession().save(goods);
	}

	@SuppressWarnings("unchecked")
	public List<Goods> listGoods() {
		return sessionFactory.getCurrentSession().createCriteria(Goods.class)
			.add(Expression.eq("isDelete","false"))
			.list();
	}
	
	public long listGoodsCount() {
		Object result = sessionFactory.getCurrentSession().createCriteria(Goods.class)
            .setProjection(Projections.rowCount()).uniqueResult();
		long count = Long.parseLong(result.toString());
	return count;
	}
	
	
	public int pageCount()
	{
		int result;
		if(listGoodsCount()%10>0)
			result=(int) (listGoodsCount()/10)+1;
		else
			result=(int) (listGoodsCount()/10);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Goods> listGoodsForPage(Integer page_number) {
		if(page_number<1)page_number=1;
		return sessionFactory.getCurrentSession().createCriteria(Goods.class)
				.add(Expression.eq("isDelete","false"))
				.setFirstResult(page_number*10-10)
                .setMaxResults(10)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Goods> listAllGoods() {
		return sessionFactory.getCurrentSession().createCriteria(Goods.class).list();
	}

	public void removeGoods(Integer id) {
		Goods goods = (Goods) sessionFactory.getCurrentSession().load(
				Goods.class, id);
        if (null != goods) {
        	goods.setIsDelete("true");
        }
	}

	public void updateGoods(Goods newGoods) {		
		if (newGoods != null) {
			newGoods.setIsDelete("false");
        	sessionFactory.getCurrentSession().update(newGoods);
        }
	}

	public Goods getGoodsByID(Integer id) {
		 return (Goods)sessionFactory.getCurrentSession().
				 createQuery("from Goods WHERE id="+id).uniqueResult();
	}

}
