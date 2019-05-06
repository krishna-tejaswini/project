package com.niit.sportsback.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sportsback.model.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
@Autowired
SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier supplier) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("New supplier cannot be saved");
			return false;	
		}
		
	}

	
	public boolean deleteSupplier(Supplier supplier) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Supplier cannot be deleted");
			return false;
		}
		
	}


	public boolean updateSupplier(Supplier supplier) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("supplier cant be updated");
			return false;
		}
		
	}

	
	public Supplier getSupplier(int ID) {
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class, ID);
		session.close();
		return null;
	}

	@Override
	public List<Supplier> list() {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from supplier");
			List<Supplier>list=(List<Supplier>)query.list();
			session.close();
			return list;
			
		}
		catch(Exception e)
		{
			System.out.println("cannot retrive supplier list");
			return null;
		}
		
	}


	public List<Supplier> listSupplierByCategoryID(int Categoryid) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from supplier where Category_CategoryId=:categoryid");
			query.setParameter("categoryid", Categoryid);
			List<Supplier>list=(List<Supplier>)query.list();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("Cannot retrive suppliers based on category");
			return null;
		}
		
	}

}
