package com.elmar.db;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cust_add database table.
 * 
 */
@Entity
@Table(name="cust_add")
@NamedQuery(name="CustAdd.findAll", query="SELECT c FROM CustAdd c")
public class CustAdd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_ADD_ID")
	private String custAddId;

	@Column(name="BILL_ADD")
	private String billAdd;

	@Column(name="HOME_ADD")
	private String homeAdd;

	@Column(name="LAST_UPDATED_TIME")
	private Timestamp lastUpdatedTime;

	@Column(name="SHIPP_ADD")
	private String shippAdd;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public CustAdd() {
	}

	public String getCustAddId() {
		return this.custAddId;
	}

	public void setCustAddId(String custAddId) {
		this.custAddId = custAddId;
	}

	public String getBillAdd() {
		return this.billAdd;
	}

	public void setBillAdd(String billAdd) {
		this.billAdd = billAdd;
	}

	public String getHomeAdd() {
		return this.homeAdd;
	}

	public void setHomeAdd(String homeAdd) {
		this.homeAdd = homeAdd;
	}

	public Timestamp getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getShippAdd() {
		return this.shippAdd;
	}

	public void setShippAdd(String shippAdd) {
		this.shippAdd = shippAdd;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}