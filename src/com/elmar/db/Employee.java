package com.elmar.db;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMP_ID")
	private long empId;

	@Column(name="ADDRESS")
	private String address;

	private String city;

	private String email;

	@Column(name="FAX_NO")
	private int faxNo;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LAST_UPDATED_TIME")
	private Timestamp lastUpdatedTime;

	private String region;

	private String resume;

	private String review;

	@Column(name="TEL_NO")
	private int telNo;

	@Column(name="WORK_NO")
	private int workNo;

	@Column(name="ZIP_CODE")
	private String zipCode;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="employee",cascade={CascadeType.ALL})
	private List<User> users;

	public Employee() {
	}

	public long getEmpId() {
		return this.empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFaxNo() {
		return this.faxNo;
	}

	public void setFaxNo(int faxNo) {
		this.faxNo = faxNo;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
  System.out.println("The Employee's firstname is in the Emp class: "+firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getTelNo() {
		return this.telNo;
	}

	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}

	public int getWorkNo() {
		return this.workNo;
	}

	public void setWorkNo(int workNo) {
		this.workNo = workNo;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setEmployee(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setEmployee(null);

		return user;
	}

}