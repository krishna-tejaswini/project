package com.niit.sportsback.dao;

import java.util.List;

import com.niit.sportsback.model.CartItems;

public interface CartDao {
public boolean addCartItems(CartItems cartItem);
public boolean deleteCartItems(CartItems cartItem);
public boolean updateCartItems(CartItems cartItem);
public CartItems getCartItems(int cartItemid);
public List<CartItems>listCartItems(String username);

}
