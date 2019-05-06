package com.niit.sportsback;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportsback.dao.UserDao;
import com.niit.sportsback.model.User;

public class UserTestCase {
static UserDao userDao;
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
	userDao=(UserDao)context.getBean("userDAO");
}
@Test
public void registerUserTest()
{
	User userdetail=new User();
	userdetail.setEmailid("abc@gmail.com");
	userdetail.setPassword("password");
	userdetail.setRole("User");
	userdetail.setFirstname("user1");
	userdetail.setLastname("user1");
	assertTrue("Problem in Registrating Userdetail in Database",userDao.registerUser(userdetail));
}

}
