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
	private Integer id_goods;

	@Column(name = "AMOUNT")
	private Integer amount;

	@Column(name = "PRICE")
	private Integer price;

	@Column(name = "createddate")
	private String date;

	// Getters and setters
	public String getDate() {
		return date;
	}
	public void setDate() {
		Date d = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		date=format1.format(d);
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer ID) {
		this.id = ID;
	}

	public Integer getid_goods() {
		return id_goods;
	}

	public void setid_goods(Integer id_goods) {
		this.id_goods = id_goods;
	}

	public Integer getamount() {
		return amount;
	}

	public void setamount(Integer amount) {
		this.amount = amount;
	}

	public Integer getprice() {
		return price;
	}

	public void setprice(Integer price) {
		this.price = price;
	}
}
