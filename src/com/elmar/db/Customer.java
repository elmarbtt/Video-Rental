package com.elmar.db;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_ID")
	private String custId;

	private String city;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LAST_UPDATED_TIME")
	private Timestamp lastUpdatedTime;

	private String region;

	@Column(name="TEL_NO")
	private int telNo;

	@Column(name="WORK_NO")
	private int workNo;

	@Column(name="ZIP_CODE")
	private String zipCode;

	//bi-directional many-to-one association to Complaint
	

	//bi-directional many-to-one association to CustAdd
	@OneToMany(mappedBy="customer")
	private List<CustAdd> custAdds;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="assignee")
	private User user;

	//bi-directional many-to-one association to PurchOrder
	

	public Customer() {
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
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

	

	public List<CustAdd> getCustAdds() {
		return this.custAdds;
	}

	public void setCustAdds(List<CustAdd> custAdds) {
		this.custAdds = custAdds;
	}

	public CustAdd addCustAdd(CustAdd custAdd) {
		getCustAdds().add(custAdd);
		custAdd.setCustomer(this);

		return custAdd;
	}

	public CustAdd removeCustAdd(CustAdd custAdd) {
		getCustAdds().remove(custAdd);
		custAdd.setCustomer(null);

		return custAdd;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}