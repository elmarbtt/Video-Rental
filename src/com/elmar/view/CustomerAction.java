package com.elmar.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.elmar.controller.CustomerDAO;
import com.elmar.db.Customer;
import com.elmar.db.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	
	
	private Customer custBean = new Customer();
	private User userBean = new User();
	
	
	
	private List<Customer> custList = new ArrayList<Customer>();;
	
	private List<User> userL = new ArrayList<User>();
	
	private CustomerDAO custDAO = new CustomerDAO();
	
	
	private Customer assignCustomer;
	
	private long compId;
	private String resolved;
	private String category;
	private String region;
	private String description;
	
	private long userId;
	private String userName;
	private String userA;
	private User userN;
	private String userS;
	
	private long custId;
	
	private Query userQ;
	
	private String searchN;
	
	private String firstName;
	private String lastName;
	private String city;
	private String zipCode;
	private String email;
	private int telNo;
	private int workNo;
	private String userAssign;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8602286336238332565L;
	
	public String Update(){
		
		
		userBean.setUserName(userName);
		userQ = custDAO.searchName(userName);
		
		//System.out.println("The user is in action class: " +(Long)userQ.uniqueResult());
		
		userId = (Long)userQ.uniqueResult();//Find out what is .uniqueResult(), you use this when you want to fetch a single object.
		//System.out.println("The userId after casting to long: " +userId);
		
		
		System.out.println("The userName is: " +userName);
		userBean.setUserId(userId);
		System.out.println("The userId is: " +userId);
		
		
		/*
		Have to include the customerId to say whose complaint it was.
		*/
		return SUCCESS;
	}
	
	/*public String search(String userName){
		
		userL = custDAO.searchName(userName);
		System.out.println("The user is in Action class: " +userL);
		
		
		return SUCCESS;
	}
*/
	
	public String AssignCust(){
		
		userBean.setUserName(userA);
		userQ = custDAO.searchName(userA);
		
		//System.out.println("The user is in action class: " +(Long)userQ.uniqueResult());
		
		userId = (Long)userQ.uniqueResult();//Find out what is .uniqueResult(), you use this when you want to fetch a single object.
		//System.out.println("The userId after casting to long: " +userId);
		
		
		System.out.println("The userName is: " +userA);
		userBean.setUserId(userId);
		System.out.println("The userId is: " +userId);
		
		
		
		custBean.setCustId(custId);
		
		custBean.setFirstName(firstName);
		custBean.setLastName(lastName);
		custBean.setCity(city);
		custBean.setZipCode(zipCode);
		custBean.setEmail(email);
		custBean.setTelNo(telNo);
		custBean.setWorkNo(workNo);
		custBean.setRegion(region);
		
		
		custBean.setUser(userBean);
		
		custDAO.AssignCustomer(custBean);
		
		return SUCCESS;
	}
	

	

	

	public User getUserBean() {
		return userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	public Customer getCustBean() {
		return custBean;
	}

	public void setCustBean(Customer custBean) {
		this.custBean = custBean;
	}

	
	
	public long getCompId() {
		return compId;
	}



	public void setCompId(long compId) {
		this.compId = compId;
	}



	public String getResolved() {
		return resolved;
	}



	public void setResolved(String resolved) {
		this.resolved = resolved;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSearchN() {
		return searchN;
	}

	public void setSearchN(String searchN) {
		this.searchN = searchN;
	}

	public User getUserN() {
		return userN;
	}

	public void setUserN(User userN) {
		this.userN = userN;
	}

	/*public Query getUserL() {
		return userL;
	}

	public void setUserL(Query userL) {
		this.userL = userL;
	}
*/
	

	public List<User> getUserL() {
		return userL;
	}

	public void setUserL(List<User> userL) {
		this.userL = userL;
	}

	public String getUserS() {
		return userS;
	}

	public void setUserS(String userS) {
		this.userS = userS;
	}

	public Query getUserQ() {
		return userQ;
	}

	public void setUserQ(Query userQ) {
		this.userQ = userQ;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCustList(List<Customer> custList) {
		this.custList = custList;
	}

	public List<Customer> getCustList() {
		return custList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserAssign() {
		return userAssign;
	}

	public void setUserAssign(String userAssign) {
		this.userAssign = userAssign;
	}

	public Customer getAssignCustomer() {
		return assignCustomer;
	}

	public void setAssignCustomer(Customer assignCustomer) {
		this.assignCustomer = assignCustomer;
	}

	public String getUserA() {
		return userA;
	}

	public void setUserA(String userA) {
		this.userA = userA;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelNo() {
		return telNo;
	}

	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}

	public int getWorkNo() {
		return workNo;
	}

	public void setWorkNo(int workNo) {
		this.workNo = workNo;
	}

	

	


}
