package com.elmar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.elmar.db.Employee;
import com.elmar.db.ProductCat;
import com.elmar.db.ProductDetail;
import com.elmar.db.Role;
import com.elmar.db.User;
import com.elmar.db.UserRole;
import com.elmar.db.util.HibernateUtil;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class UserDAO {
	
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	
	/**
	 * Used to save or update a user.
	 */
	
public void SaveOrUpdateUser(Employee emp,User user, String role, String addrole) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			
			user.setEmployee(emp);
			
		
			/* The problem I am receiving is that it is only persisting data in user tables and 
			 * not in department and employee table. 
			 * I used cascade to solve this issue
			*/
			Role rol = new Role();
			rol.setRole(role);
			
			Role rol2 = new Role();
			rol2.setRole(addrole);
			//user.setRoles3(roles);
		
		    
			rol.setUser2(user);
			rol2.setUser2(user);
			
			//user2 is to say who created the role for this user.
			//user.getRole().add(rol);
			//user.getRole().add(rol2);
			
			//set the role of the user.  
		   
			
		    
		   
			session.save(user);
		//    session.save(role);
		   
		//	UserRole userrole = new UserRole();
			/*System.out.println("userrolePK id is: "+userrole.getId());
		    UserRolePK userr = new UserRolePK();
		    userr.setRole_ID(role.getRoleId());
		    System.out.println("role id is: "+userr);
		    userr.setUser_ID(user.getUserId());
		    System.out.println("user id is: "+userr);*/
			
		  //  session.save(userr);
		    
		   
		   // System.out.println(userrole.getUser_role_ID());
		   // userrole.setRole2(role);
			//userrole.setUser2(user);
		  
		   // session.save(userrole);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

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

@SuppressWarnings("unchecked")
public List<User> listUser() {
	List<User> users = null;
	try {
		users = session.createQuery("from User").list();
		//Iterator it = users.iterator();
		/*while (it.hasNext()){
			User user = (User) it.next();
			
			System.out.println("username: "+user.getUser2().getUserName());
			System.out.println("role_name: "+user.getRole2().getRole());
			
			session.createQuery("SELECT u FROM ProductDetail p " +
                    "WHERE p.name LIKE '%"+searchW+"%' " ).list();
			
			"SELECT userName, role FROM User u, Role r, UserRole b" + 
			"WHERE u.user_ID = 1 AND u.user_ID = b.user_ID"
			
		}*/
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return users;
}

public void deleteUser(Long userId) {
	try {
		User user = (User) session.get(User.class, userId);
		session.delete(user);
	} catch (Exception e) {
		transaction.rollback();
		e.printStackTrace();
	} 
}

@SuppressWarnings("unchecked")
public List<UserRole> listRole() {
	List<UserRole> users = null;
	try {
		users = session.createQuery("from UserRole").list();
		//Iterator it = users.iterator();
		/*while (it.hasNext()){
			User user = (User) it.next();
			
			System.out.println("username: "+user.getUser2().getUserName());
			System.out.println("role_name: "+user.getRole2().getRole());
			
			session.createQuery("SELECT u FROM ProductDetail p " +
                    "WHERE p.name LIKE '%"+searchW+"%' " ).list();
			
			"SELECT userName, role FROM User u, Role r, UserRole b" + 
			"WHERE u.user_ID = 1 AND u.user_ID = b.user_ID"
			
		}*/
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return users;
}


public User listUserById(Long userId) {
	User user = null;
	try {
		user = (User) session.get(User.class, userId);
		System.out.println("The userId is: "+user.getUserId());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return user;
}

public List<UserRole> listUserRoleById(Long userId) {
	List<UserRole> userR = null;
	try {
		
		
		//System.out.println("The userId is in the DAO: "+userId);
		
		userR = session.createQuery("SELECT U.userName, R.role FROM User U,Role R, UserRole A "+
				                       "WHERE U.userId = ?1" 
				                     +" AND U.userId = A.user1 "+
				                           "AND A.role1 = R.role_id").list();
	
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return userR;
}

public Query searchName(String userName){
	
    
	
	Query users = null;
		
		//User users2 = new User();
		
		try{
			
		 users = session.createQuery("SELECT u.userName FROM User u " +
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


public User findUser(String userName){
	
	User user = null;
	try {
		user = (User) session.createQuery("from User where userName=:userName").setParameter("userName", userName).uniqueResult();
		System.out.println("The userId is: "+user.getUserId());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return user;
	
	
	
	
}

	

}
