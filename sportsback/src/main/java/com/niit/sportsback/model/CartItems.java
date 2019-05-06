package com.niit.sportsback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class CartItems {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int cartitemid;
private int productid;
private int price;
private int quantity;
private String productname;
private int orderid;
private String username;
private String status;
public int getCartitemid() {
	return cartitemid;
}
public void setCartitemid(int cartitemid) {
	this.cartitemid = cartitemid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
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
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
