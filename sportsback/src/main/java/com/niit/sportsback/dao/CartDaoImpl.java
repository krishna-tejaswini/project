package com.niit.sportsback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sportsback.model.CartItems;
@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addCartItems(CartItems cartItem) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(cartItem);
return true;
			}
		catch(Exception e){
			
			return false;
		}
		
	}

	
	public boolean deleteCartItems(CartItems cartItem) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(cartItem);
return true;
			}
		catch(Exception e){
			
			return false;
		}
		
	}

	

	
	public boolean updateCartItems(CartItems cartItem) {
		
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(cartItem);
return true;
			}
		catch(Exception e){
			
			return false;
		}
		
	}

	

	
	public CartItems getCartItems(int cartItemid) {
		
		try {
			Session session=sessionFactory.openSession();
			CartItems cart=(CartItems)session.get(CartItems.class, cartItemid);
			
			session.close();
return cart;
			}
		catch(Exception e){
			
			return null;
		}
		
	}

	

	
	public List<CartItems> listCartItems(String username) {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from CartItems where username=:userName");
			query.setParameter("userName", username);
			List<CartItems>listCartItems=(List<CartItems>)query.list();
			return listCartItems;
			
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

}
