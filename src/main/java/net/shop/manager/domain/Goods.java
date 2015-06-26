package net.shop.manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "GOODS")
public class Goods {

		@Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(name = "NOMINATION")
	    private String nomination;

	    @Column(name = "PRICE")
	    private Float price;
	    
	    @Column(name = "ISDELETE")
	    private String isDelete;

	    
	    // Getters and setters
	    public Integer getId()
	    {
	    	return id;
	    }
	    public void setId(Integer ID)
	    {
	    	this.id=ID;
	    } 
	    public String getNomination()
	    {
	    	return nomination;
	    }
	    public void setNomination(String nomination)
	    {
	    	this.nomination=nomination;
	    }
	    public Float getPrice()
	    {
	    	return price;
	    }
	    public void setPrice(Float price)
	    {
	    	this.price=price;
	    }
	    public String getIsDelete()
	    {
	    	return isDelete;
	    }
	    public void setIsDelete(String isDelete)
	    {
	    	this.isDelete=isDelete;
	    }
}
