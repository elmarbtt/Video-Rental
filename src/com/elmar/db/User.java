package com.elmar.db;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long userId;

	@Column(name="LAST_UPDATED_TIME")
	private Timestamp lastUpdatedTime;

	private String password;
	
	private Boolean enabled;

	@Column(name="USER_NAME")
	private String userName;

	/*//bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy="user")
	private List<Complaint> complaints;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="user")
	private List<Customer> customers;
*/
	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="user1")
	private List<Role> roles1;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="user2")
	private List<Role> roles2;

	

	//bi-directional many-to-one association to Employee
	@ManyToOne(cascade={CascadeType.ALL})
	/*Cascade.ALL means that the persistence will propagate(cascade)
	 *  all operations(PERSIST, REMOVE, REFRESH, MERGE, DETACH)to relating entities.
	*/
	@JoinColumn(name="EMP_ID")
	private Employee employee;
	/*
	After I inserted the cascade line it then persisted the data in all the tables, that were linked to User table.
	
	*/
	//bi-directional many-to-many association to Role
		@ManyToMany(cascade={CascadeType.ALL})
		@JoinTable(
			name="user_roles"
			, joinColumns={
				@JoinColumn(name="user_ID")
				}
			, inverseJoinColumns={
				@JoinColumn(name="role_ID")
				}
			//inverse is the non-owning side
			)
		
		private Set<Role> role = new HashSet<Role>();
		//Set is used such that no duplicate values can be stored.
		
		@OneToMany(mappedBy="user1")
		private List<UserRole> userRoles1;

		//bi-directional many-to-one association to UserRole
		@OneToMany(mappedBy="user2")
		private List<UserRole> userRoles2;


	public User() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Timestamp getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		System.out.println("The user name is in the user class: "+userName);
		this.userName = userName;
	}

	/*public List<Complaint> getComplaints() {
		return this.complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Complaint addComplaint(Complaint complaint) {
		getComplaints().add(complaint);
		complaint.setUser(this);

		return complaint;
	}

	public Complaint removeComplaint(Complaint complaint) {
		getComplaints().remove(complaint);
		complaint.setUser(null);

		return complaint;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setUser(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setUser(null);

		return customer;
	}*/

	public List<Role> getRoles1() {
		return this.roles1;
	}

	public void setRoles1(List<Role> roles1) {
		this.roles1 = roles1;
	}

	public List<Role> getRoles2() {
		return this.roles2;
	}

	public void setRoles2(List<Role> roles2) {
		this.roles2 = roles2;
	}

	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<UserRole> getUserRoles1() {
		return userRoles1;
	}

	public void setUserRoles1(List<UserRole> userRoles1) {
		this.userRoles1 = userRoles1;
	}

	public List<UserRole> getUserRoles2() {
		return userRoles2;
	}

	public void setUserRoles2(List<UserRole> userRoles2) {
		this.userRoles2 = userRoles2;
	}


	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	/*public void setUserRoles2(UserRole userRoles2) {
		this.userRoles2 = userRoles2;
	}
*/

}