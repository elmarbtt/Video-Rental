package com.elmar.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.elmar.controller.UserDAO;
import com.elmar.db.Employee;
import com.elmar.db.ProductDetail;
import com.elmar.db.Role;
import com.elmar.db.User;
import com.elmar.db.UserRole;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4191624207863680748L;
	
	private Employee empBean = new Employee();
	private User userBean = new User();
	private Role roleBean = new Role();
	
	
	private List<User> userList = new ArrayList<User>();
	private List<UserRole> roleList = new ArrayList<UserRole>();
	
	private UserDAO userDAO = new UserDAO();
	private User usert;
	private UserRole userR;
	
	private String role;
	private String addrole;
	
	private long empId;
	private String firstName;
	private String lastName;
	private String email;
	private int workNo;
	private int telNo;
	private String address;
	private String city;
	private String zipCode;
	private String region;
	private String resume;
	private String review;
	
	private long deptId;
	private String deptName;
	
	private long userId;
	/*private String userName;
	private String password;*/
	
public String saveOrUpdate() {

		
		userDAO.SaveOrUpdateUser(empBean, userBean, role, addrole);
		//arguments must be in the correct order when sending to DAO
		return SUCCESS;
		
		/*I am transferring the object reference of prodCatBean, prodBean to the DAO from the JSP. 
		 *The beans are populated in the User Registration JSP. 
		 */
	}

public String list() {
	 userList = userDAO.listUser();
	return SUCCESS;
	/*I am currently receiving a error saying that it wants to put data in user table before
	 * it puts data in the employee table and department table.
	 * 
	 * I solved the above error, by doing the following: 
	 * I inserted the cascade line it then persisted the data in all the tables, that were linked to User table. 
	*/
}

public String Update() {
	/*
	Because of the Employee and Department being FK's i have to set the id's and than
	there values in the action class in order to have access to the Java beans of Emp and Dept.
	
	With User it is not necessary to set the id and values in the Action class, because it is the PK
	there for I can directly call the User bean from the JSP to set the new values that I need to change
	in the database.
	*/
	empBean.setEmpId(empId);
	System.out.println("The Employee ID is: "+empId);
	empBean.setFirstName(firstName);
	System.out.println("The Employee's firstname: "+firstName);
	empBean.setLastName(lastName);//Can set/change the lastname value using empBean.
	System.out.println("The Employee's lastname: "+lastName);
	empBean.setEmail(email);
	empBean.setWorkNo(workNo);
	empBean.setTelNo(telNo);
	empBean.setAddress(address);
	System.out.println("The Employee's address: "+address);
	empBean.setCity(city);
	empBean.setZipCode(zipCode);
	empBean.setRegion(region);
	empBean.setResume(resume);
	empBean.setReview(review);
	
	
	
	
	userBean.setUserId(userId);// Have to identify the ID, when object is sent to DAO for persistence. Otherwise it complains about null identifier.
	/*System.out.println("The user ID is: "+userId);
	userBean.setUserName(userName);
	System.out.println("The user name is: "+userName);
	userBean.setPassword(password);*/
	
	userBean.setEmployee(empBean);
	
	
	
	userDAO.UpdateUser(userBean);
	
	return SUCCESS;
	
	/*I first need to set the Product Category ID before I pass it to the DAO, because after I click on submit it looses the ID.
	  The Product Type isn't necessary to set it in the Action Class, but it by doing this here i can use one method in the DAO for Saving and Updating.
	  I am currently receiving the old record and updated record after altering product.
	  Complaint: Hibernate: insert into product_detail, is the complaint currently(inserting instead of updating)
	  I solved this by declaring the productDetail ID.
	*/
}

/*public String listRole() {
	roleList = userDAO.listRole();
	return SUCCESS;
	I am currently receiving a error saying that it wants to put data in user table before
	 * it puts data in the employee table and department table.
	 * 
	 * I solved the above error, by doing the following: 
	 * I inserted the cascade line it then persisted the data in all the tables, that were linked to User table. 
	
}*/

public String listRoleId() {
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	roleList = userDAO.listUserRoleById(Long.parseLong(request.getParameter("id")));
	

	/* The name of the id name in JSP must be the same as the one getting the parameters
	 * prodt is an object reference for productCategory, this will be used to display selected ID values in Update JSP
	*/
	
	return SUCCESS;
}

public String edit() {
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	usert = userDAO.listUserById(Long.parseLong(request.getParameter("id")));
	

	/* The name of the id name in JSP must be the same as the one getting the parameters
	 * prodt is an object reference for productCategory, this will be used to display selected ID values in Update JSP
	*/
	
	return SUCCESS;
}

public String delete() {
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	userDAO.deleteUser(Long.parseLong(request.getParameter("id")));

	/* The name of the id name in JSP must be the same as the one getting the parameters
	 * I use the following ID to delete a item: ProductDetail.prodDetId
	*/
	System.out.println("Deleting a User");
	return SUCCESS;
}
	
	
	
	public Employee getEmpBean() {
		return empBean;
	}
	
	public void setEmpBean(Employee empBean) {
		this.empBean = empBean;
	}
	
	public User getUserBean() {
		return userBean;
	}
	
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	public Role getRoleBean() {
		return roleBean;
	}

	public void setRoleBean(Role roleBean) {
		this.roleBean = roleBean;
	}

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getAddrole() {
		return addrole;
	}

	public void setAddrole(String addrole) {
		this.addrole = addrole;
	}

	public User getUsert() {
		return usert;
	}

	public void setUsert(User usert) {
		this.usert = usert;
	}

	public UserRole getUserR() {
		return userR;
	}

	public void setUserR(UserRole userR) {
		this.userR = userR;
	}

	public List<UserRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<UserRole> roleList) {
		this.roleList = roleList;
	}

	

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getWorkNo() {
		return workNo;
	}

	public void setWorkNo(int workNo) {
		this.workNo = workNo;
	}

	public int getTelNo() {
		return telNo;
	}

	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	

	/*public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("The Employee's firstname in set method: "+firstName);
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
