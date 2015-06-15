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
	    private Integer price;
	    
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
	    public String getnomination()
	    {
	    	return nomination;
	    }
	    public void setnomination(String nomination)
	    {
	    	this.nomination=nomination;
	    }
	    public Integer getprice()
	    {
	    	return price;
	    }
	    public void setprice(Integer price)
	    {
	    	this.price=price;
	    }
	    public String getisDelete()
	    {
	    	return isDelete;
	    }
	    public void setisDelete(String isDelete)
	    {
	    	this.isDelete=isDelete;
	    }
}
