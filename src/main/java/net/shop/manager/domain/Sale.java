package net.shop.manager.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALE")
public class Sale {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ID_GOODS")
	private Integer idGoods;

	@Column(name = "AMOUNT")
	private Integer amount;

	@Column(name = "PRICE")
	private Float price;
	
	@Column(name = "discount_price")
	private Float discountPrice;
	
	@Column(name = "discount")
	private String discount;
	
	@Column(name = "createddate")
	private Date date;
	
	// Getters and setters
	public Date getDate() {
		return date;
	}
	public void setDate() {
		date = new Date();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Float discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
}
