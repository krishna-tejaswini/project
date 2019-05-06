package com.niit.sportsback;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportsback.dao.CartDao;
import com.niit.sportsback.dao.CategoryDao;
import com.niit.sportsback.model.CartItems;
import com.niit.sportsback.model.Category;

public class CartItemTestCase {
	static CartDao cartDao;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		cartDao=(CartDao)context.getBean("cartDao");
		
	}
	@Test
	public void addCart()
	{
		CartItems cart=new CartItems();
		cart.setOrderid(1);
		cart.setPrice(1000);
		cart.setProductid(1);
		cart.setProductname("shoes");
		cart.setQuantity(2);
		cart.setUsername("user1");
		cart.setStatus("p");
	assertEquals("New cart cannot be created",true,cartDao.addCartItems(cart))	;

}
	@Test
	public void listCartItemsTest()
	{
		List<CartItems>listCart=cartDao.listCartItems("user1");
		assertTrue("problem in listing Cart Items from DataBase",listCart.size()>0);
		for(CartItems cart:listCart)
		{
			System.out.println(cart.getProductname()+" ");
			System.out.println(cart.getUsername()+" ");
			System.out.println(cart.getStatus()+" "+cart.getOrderid());
		}
			
	}
	
}
