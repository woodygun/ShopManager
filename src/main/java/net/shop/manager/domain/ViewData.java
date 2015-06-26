package net.shop.manager.domain;

public class ViewData {
	private Integer idGoods;
	private Integer amount;
	private String nomination;
	private Float price;
	
	public Integer getIdGoods() {
		return idGoods;
	}
	public void setIdGoods(Integer idGoods) {
		this.idGoods = idGoods;
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Goods getGoodsForUpdate(Integer idGoods)
	{
		Goods newGoods=new Goods();
		newGoods.setId(idGoods);
    	newGoods.setNomination(nomination);
    	newGoods.setPrice(price);
    	newGoods.setIsDelete("false");
    	
    	return newGoods;
	}
	public Goods getNewGoods()
	{
		Goods newGoods=new Goods();
    	
    	newGoods.setNomination(nomination);
    	newGoods.setPrice(price);
    	newGoods.setIsDelete("false");
    	
    	return newGoods;
	}
	public Sale getNewSale()
	{
		Sale newSale=new Sale();
		
		newSale.setIdGoods(idGoods);
		newSale.setAmount(amount);
		newSale.setDate();
		
		return newSale;
	}
}
