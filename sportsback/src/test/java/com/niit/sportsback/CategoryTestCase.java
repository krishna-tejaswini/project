package com.niit.sportsback;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportsback.dao.CategoryDao;
import com.niit.sportsback.model.Category;


public class CategoryTestCase {
static CategoryDao categoryDAO;//static variable created
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext("com");
	// ac is spring container as bean factory doesn't support annotations .it is a type of application context used to create singleton objects from package called com
	
	categoryDAO=(CategoryDao)ac.getBean("categoryDAO");
	//start searching for annotated classes  from com package and create objects
}
//@Ignore
@Test
public void addCategory()
{
	Category category=new Category();
	category.setCategoryid(1);
	category.setCategoryname("shoes");
	category.setCategorydescription("footware");
	assertEquals("category insertion failed",true,categoryDAO.insertCategory(category));	
}
@Ignore
@Test
public void removeCategory()
{
Category category=categoryDAO.getCategory(1);
assertEquals("category removal failed",true,categoryDAO.deleteCategory(category));//here it is a overloaded method with 3 parameters
}
@Ignore
@Test
public void updateCategory()
{
	Category category=categoryDAO.getCategory(33);
	category.setCategoryname("spikes");
	category.setCategorydescription("Running shoes");
	assertEquals("category updation failed",true,categoryDAO.updateCategory(category));
	
}
@Ignore
@Test
public void listCategoriesTest()
{
	List<Category>listCategories=categoryDAO.getCategories();
	assertTrue("Problem in listing categories from database",listCategories.size()>0);
	for(Category category:listCategories)
	{
		System.out.print(category.getCategoryid()+" ");
		System.out.print(category.getCategoryname()+" ");
		System.out.println(category.getCategorydescription());
		
	}
}
}


	
	
	