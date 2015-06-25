package net.shop.manager.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISCOUNTS")
public class Discounts {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "ID_GOODS")
	private Integer idGoods;
	
	@Column(name = "DISCOUNT_AMOUNT")
	private Integer discountAmount;
	
	@Column(name = "PRICES_START")
	private Date pricesStart;
	
	@Column(name = "PRICES_END")
	private Date pricesEnd;
	
	@Column(name = "STATUS")
	private String status;
	
	
	public String getStatus()
    {
    	return status;
    }
    public void setStatus(String status)
    {
    	this.status=status;
    } 
	public Integer getId()
    {
    	return id;
    }
    public void setId(Integer ID)
    {
    	this.id=ID;
    } 
    public Integer getIdGoods() {
		return idGoods;
	}
	public void setIdGoods(Integer id_goods) {
		this.idGoods = id_goods;
	}
	public Integer getDiscountAmount()
    {
    	return discountAmount;
    }
    public void setDiscountAmount(Integer discountAmount)
    {
    	this.discountAmount=discountAmount;
    }
    public Date getPricesStart()
    {
    	return pricesStart;
    }
    public void setPricesStart(Date pricesStart)
    {
    	this.pricesStart=pricesStart;
    }
    public Date getPricesEnd()
    {
    	return pricesEnd;
    }
    public void setPricesEnd(Date pricesEnd)
    {
    	this.pricesStart=pricesEnd;
    }
}
