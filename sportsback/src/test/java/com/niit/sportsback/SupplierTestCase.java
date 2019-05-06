package com.niit.sportsback;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportsback.dao.SupplierDao;
import com.niit.sportsback.model.Category;
import com.niit.sportsback.model.Supplier;

public class SupplierTestCase {
static SupplierDao supplierDAO;
@BeforeClass
public static void intialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
	supplierDAO=(SupplierDao)context.getBean("supplierDAO");
	
}
	//@Ignore
@Test
public void insertSupplier()
{
	Supplier supplier=new Supplier();
	Category category =new Category();
	category.setCategoryname("Badminton");
	category.setCategorydescription("Badminton Raquet");
	System.out.println(category.getCategoryid());
	supplier.setSuppliername("yonex");
	supplier.setSupplierstock(16);
	//supplier.setCategory(category);
	assertEquals("Cannot Insert data",true,supplierDAO.addSupplier(supplier));
		
}
//@Ignore
@Test
public void listSuppliers()
{
	List<Supplier>list=supplierDAO.list();
	assertTrue("Problem in Listing suppliers from Database",list.size()>0);
	for(Supplier supplier:list)
	{
		System.out.println(supplier.getSupplierid()+" ");
		System.out.println(supplier.getSuppliername()+" ");
		//System.out.println(supplier.getCategory().getCategorydescription()+" "+supplier.getSupplierstock());
		
	}
}
//@Ignore
@Test
public void listSuppliersByCategory()
{
	List<Supplier>list=supplierDAO.listSupplierByCategoryID(33);
	assertTrue("problem in Listing suppliers from Database",list.size()>0);
	for(Supplier suppliers:list)
	{
		System.out.println(suppliers.getSupplierid()+" ");
		System.out.println(suppliers.getSuppliername()+" ");
		//System.out.println(suppliers.getCategory().getCategorydescription()+" "+suppliers.getSupplierstock());	
	}
}
}
