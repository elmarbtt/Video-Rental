package com.elmar.db;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.mapping.Set;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the product_detail database table.
 * 
 */
@Entity
@Table(name="product_detail")
@NamedQuery(name="ProductDetail.findAll", query="SELECT p FROM ProductDetail p")
public class ProductDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROD_DET_ID")
	private Long prodDetId;

	@Column(name="CURRENCY")
	private String currency;

	@Column(name="LAST_UPDATED_TIME")
	private Timestamp lastUpdatedTime;


	@Column(name="PROD_DESC")
	private String prodDesc;

	@Column(name="PROD_INFO")
	private String prodInfo;

	@Column(name="PROD_NAME")
	private String prodName;

	@Column(name="REGULAR_PRICE")
	private double regularPrice;

	@Column(name="SIZE")
	private String size;
	
	//private Set<ProductCat> prodType;

	/*//bi-directional many-to-one association to OrderConfirm
	@OneToMany(mappedBy="productDetail")
	private List<OrderConfirm> orderConfirms;*/

	/*//bi-directional many-to-many association to PurchOrder
	@ManyToMany(mappedBy="productDetails")
	private List<PurchOrder> purchOrders;*/
	
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="PROD_CAT_ID")
	private ProductCat productCat;
	
	
	
	/*@OneToMany(mappedBy="productDetail")
	@JoinColumn (name = "PROD_DET_ID")
	private List<ProductCat> productCat = new ArrayList<ProductCat>();*/
	
	/*@OneToMany(mappedBy = "productDetail", cascade = {CascadeType.ALL})
	@JoinColumn (name = "PROD_DET_ID")
	private List<ProductCat> productCat;*/
	//private ProductCat productCat;
	
	
	

	

	/*public List<ProductCat> getProductCat() {
		return productCat;
	}

	public void setProductCat(List<ProductCat> productCat) {
		this.productCat = productCat;
	}
	
	public ProductCat addProductCat(ProductCat productCat) {
		//getProductCat().add(productCat);
		productCat.setProductDetail(this);
		this.productCat.add(productCat);
		System.out.println("The product type is in prodDet :" +productCat);

		return productCat;
	}*/

	public ProductDetail() {
	}

	public Long getProdDetId() {
		return this.prodDetId;
	}

	public void setProdDetId(Long prodDetId) {
		this.prodDetId = prodDetId;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Timestamp getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}


	public String getProdDesc() {
		return this.prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdInfo() {
		return this.prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getRegularPrice() {
		return this.regularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	/*public List<OrderConfirm> getOrderConfirms() {
		return this.orderConfirms;
	}

	public void setOrderConfirms(List<OrderConfirm> orderConfirms) {
		this.orderConfirms = orderConfirms;
	}

	public OrderConfirm addOrderConfirm(OrderConfirm orderConfirm) {
		getOrderConfirms().add(orderConfirm);
		orderConfirm.setProductDetail(this);

		return orderConfirm;
	}

	public OrderConfirm removeOrderConfirm(OrderConfirm orderConfirm) {
		getOrderConfirms().remove(orderConfirm);
		orderConfirm.setProductDetail(null);

		return orderConfirm;
	}*/

	/*public List<PurchOrder> getPurchOrders() {
		return this.purchOrders;
	}

	public void setPurchOrders(List<PurchOrder> purchOrders) {
		this.purchOrders = purchOrders;
	}*/

	public void setProductCat(ProductCat productCat) {
		this.productCat = productCat;
	}

	public ProductCat getProductCat() {
		return productCat;
	}
	
	



	

}