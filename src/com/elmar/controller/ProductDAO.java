package com.elmar.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.elmar.db.ProductCat;
import com.elmar.db.ProductDetail;
import com.elmar.db.util.HibernateUtil;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;



public class ProductDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	
	/**
	 * Used to save or update a user.
	 */
	
	public void SaveOrUpdateProd(ProductCat prodC,ProductDetail prodD) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//prodD.setProduct(product);
			//prodC.setProductDetail(prodD);  
			prodD.setProductCat(prodC);
			
			session.save(prodD);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void UpdateProd(ProductDetail prodD) {
	
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			
			
			session.update(prodD);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to delete a user.
	 */
	
	public void deleteProd(Long prodDetId) {
		try {
			ProductDetail prod = (ProductDetail) session.get(ProductDetail.class, prodDetId);
			session.delete(prod);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductDetail> listProd() {
		List<ProductDetail> courses = null;
		try {
			courses = session.createQuery("from ProductDetail").list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductCat> listProdCat() {
		List<ProductCat> courses = null;
		try {
			courses = session.createQuery("from ProductCat").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	
	/**
	 * Used to list a single user by Id.
	 */
	
	public ProductDetail listUserById(Long prodDetId) {
		ProductDetail prod = null;
		try {
			prod = (ProductDetail) session.get(ProductDetail.class, prodDetId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductDetail> searchWord(String searchW){
		
	     
		List<ProductDetail> prods = new ArrayList<ProductDetail>();
		
		try{
			
			prods = session.createQuery("SELECT u FROM ProductDetail p " +
                    "WHERE p.name LIKE '%"+searchW+"%' " ).list();
			 System.out.println(searchW);
             
		}catch (Exception e) {
			e.printStackTrace();
		}
		  return prods;
		
		}



}
