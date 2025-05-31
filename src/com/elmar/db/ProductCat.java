package com.elmar.db;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product_cat database table.
 * 
 */
@Entity
@Table(name="product_cat")
@NamedQuery(name="ProductCat.findAll", query="SELECT p FROM ProductCat p")
public class ProductCat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROD_CAT_ID")
	private Long prodCatId;

	@Column(name="LAST_UPDATED_TIME")
	private Timestamp lastUpdatedTime;


	@Column(name="PROD_TYPE")
	private String prodType;

	//bi-directional many-to-one association to ProductDetail
	/*@OneToMany(mappedBy="productCat", cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<ProductDetail> productDetails;*/
	
	/*@Id
	@GeneratedValue(generator = "foreign")
	@GenericGenerator(name = "foreign", strategy = "foreign", parameters = {@Parameter(value = "prodDet", name = "property")})
	@Column(name="PROD_DET_ID")
	private int prodDetId;*/
	
	/*@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn( name="PROD_DET_ID")
	private ProductDetail productDetail;*/
	
	@OneToMany(mappedBy="productCat")
	private List<ProductDetail> productDetails;
	
	

	public ProductCat() {
	}

	public Long getProdCatId() {
		return this.prodCatId;
	}

	public void setProdCatId(Long prodCatId) {
		this.prodCatId = prodCatId;
	}

	public Timestamp getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	
	public String getProdType() {
		return this.prodType;
	}

	public void setProdType(String prodType) {
		System.out.println("The product type: "+prodType);
		this.prodType = prodType;
	}

	public List<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	/*public List<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetail addProductDetail(ProductDetail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setProductCat(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setProductCat(null);

		return productDetail;
	}*/

	

	/*public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public List<ProductDetail> getProductDetails() {
		return productDetails;
	}*/

	/*public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}*/

	

}