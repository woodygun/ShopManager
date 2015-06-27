package net.shop.manager.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salesstatistics")
public class SalesStatistics {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	//Статистика с
	@Column(name = "sales_start")
	private Date salesStart;
	
	//Статистика до
	@Column(name = "sales_end")
	private Date salesEnd;
	
	//Количество чеков
	@Column(name = "amount")
	private Integer amount;
	
	//Общая стоимость
	@Column(name = "checks_total_value")
	private Float checksTotalValue;
	
	//Средняя стоимость
	@Column(name = "checks_average_value")
	private Float checksAverageValue;
	
	//Сумма скидок
	@Column(name = "amount_of_discounts")
	private Float amountOfDiscounts;
	
	//Общая стоимость с учётом скидок
	@Column(name = "checks_discounts_total_value")
	private Float checksDiscountsTotalValue;
	
	//Средняя стоимость с учётом скидок
	@Column(name = "checks_discounts_average_value")
	private Float checksDiscountsAverageValue;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Float getChecksTotalValue() {
		return checksTotalValue;
	}
	public void setChecksTotalValue(Float checksTotalValue) {
		this.checksTotalValue = checksTotalValue;
	}
	public Float getChecksAverageValue() {
		return checksAverageValue;
	}
	public void setChecksAverageValue(Float checksAverageValue) {
		this.checksAverageValue = checksAverageValue;
	}
	public Float getAmountOfDiscounts() {
		return amountOfDiscounts;
	}
	public void setAmountOfDiscounts(Float amountOfDiscounts) {
		this.amountOfDiscounts = amountOfDiscounts;
	}
	public Float getChecksDiscountsTotalValue() {
		return checksDiscountsTotalValue;
	}
	public void setChecksDiscountsTotalValue(Float checksDiscountsTotalValue) {
		this.checksDiscountsTotalValue = checksDiscountsTotalValue;
	}
	public Float getChecksDiscountsAverageValue() {
		return checksDiscountsAverageValue;
	}
	public void setChecksDiscountsAverageValue(Float checksDiscountsAverageValue) {
		this.checksDiscountsAverageValue = checksDiscountsAverageValue;
	}

	public Date getSalesStart()
    {
    	return salesStart;
    }
    public void setSalesStart(Date salesStart)
    {
    	this.salesStart=salesStart;
    }
    public Date getSalesEnd()
    {
    	return salesEnd;
    }
    public void setSalesEnd(Date salesEnd)
    {
    	this.salesEnd=salesEnd;
    }
}
