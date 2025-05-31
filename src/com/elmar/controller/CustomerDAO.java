package com.elmar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.elmar.db.Customer;
import com.elmar.db.ProductDetail;
import com.elmar.db.User;
import com.elmar.db.util.HibernateUtil;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class CustomerDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	
	public void UpdateUser(User userB){
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.update(userB);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}
	
	
	
public void AssignCustomer(Customer cust){
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.update(cust);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
		
		
		
	}

	
	
   public Query searchName(String userName){
		
	     
		
	Query users = null;
		
		//User users2 = new User();
		
		try{
			
		 users = session.createQuery("SELECT u.userId FROM User u " +
	                "WHERE u.userName = '"+userName+"' " ); // I had .list() and List, that is why it displayed it in a arryList
		
		   /*
			I have to find out why when I said Query it worked as well, is it necessary
			*/
			System.out.println("The userId is: "+users.uniqueResult());//Can show me a answer if I use .list(), but not other methods.
			
			
	         
		}catch (Exception e) {
			e.printStackTrace();
		}
		  return users;
		
		}
   
   @SuppressWarnings("unchecked")
	public List<Customer> listCust() {
		List<Customer> comps = null;
		try {
			comps = session.createQuery("from Customer").list();
			
			/*	Iterator it = comps.iterator();
			while (it.hasNext()){
				Customer user = (Customer) it.next();
				
				System.out.println("username: "+user.getUser().getUserId());
				System.out.println("role_name: "+user.getRole2().getRole());
				
		session.createQuery("SELECT u FROM ProductDetail p " +
	                    "WHERE p.name LIKE '%"+searchW+"%' " ).list();
				
				"SELECT userName, role FROM User u, Role r, UserRole b" + 
				"WHERE u.user_ID = 1 AND u.user_ID = b.user_ID"
				
			}*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comps;
	}
   
   /*public void deleteAssignCust(Long custId) {
		try {
			Customer user = (Customer) session.get(Customer.class, custId);
			long users = user.getUser().getUserId();
			System.out.println();
			System.out.println("The user being deleted is: "+users);
			session.delete(users);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}*/
	
	

}
