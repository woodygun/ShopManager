package net.shop.manager.domain;

public class ViewData {
	private Integer id_goods;
	private Integer amount;
	private String nomination;
	private Integer price;
	
	public Integer getId_goods() {
		return id_goods;
	}
	public void setId_goods(Integer id_goods) {
		this.id_goods = id_goods;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getNomination() {
		return nomination;
	}
	public void setNomination(String nomination) {
		this.nomination = nomination;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Goods getGoodsForUpdate(Integer id_goods)
	{
		Goods NewGoods=new Goods();
		NewGoods.setId(id_goods);
    	NewGoods.setnomination(nomination);
    	NewGoods.setprice(price);
    	NewGoods.setisDelete("false");
    	
    	return NewGoods;
	}
	public Goods getNewGoods()
	{
		Goods NewGoods=new Goods();
    	
    	NewGoods.setnomination(nomination);
    	NewGoods.setprice(price);
    	NewGoods.setisDelete("false");
    	
    	return NewGoods;
	}
	public Sale getNewSale()
	{
		Sale NewSale=new Sale();
		
		NewSale.setid_goods(id_goods);
		NewSale.setamount(amount);
		NewSale.setDate();
		
		return NewSale;
	}
}
