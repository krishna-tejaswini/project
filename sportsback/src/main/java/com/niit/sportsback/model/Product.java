package com.niit.sportsback.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int productid;
	private String productname;
	private String productdescription;
	@Transient
	private int quantity;
	private int stock;
	private int price;
	@Transient
	 MultipartFile prodimage;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="Category_id",insertable=false,updatable=false)
	private Category category;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public MultipartFile getProdimage() {
		return prodimage;
	}
	public void setProdimage(MultipartFile prodimage) {
		this.prodimage = prodimage;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
