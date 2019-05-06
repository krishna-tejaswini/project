package com.niit.sportsback.dao;

import java.util.List;

import com.niit.sportsback.model.Supplier;

public interface SupplierDao  {
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
public Supplier getSupplier(int ID);
public List<Supplier>list();
public List<Supplier> listSupplierByCategoryID(int Categoryid);

}
