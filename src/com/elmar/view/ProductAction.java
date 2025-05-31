package com.elmar.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.elmar.controller.ProductDAO;
import com.elmar.db.ProductCat;
import com.elmar.db.ProductDetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.Preparable;

public class ProductAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8197096577756093260L;
	
	
	
	//Is it good practice to set this to private
	private ProductDetail prodBean = new ProductDetail();
	private ProductCat prodCatBean = new ProductCat();
	
	private List<ProductDetail> prodList = new ArrayList<ProductDetail>();
	private List<ProductCat> prodCat = new ArrayList<ProductCat>();

	private ProductDAO prodDAO = new ProductDAO();

	private ProductDetail prodt;
	private String prodType;
	private List<String> p;
	private long prodCatId;
	private long prodDetId;
	private long prodId;
	
	
	private String currency;
	private double regularPrice;
	private String prodInfo;


	private int qty;

	
	/*public ProductAction(){
		
		
		//populate();
		
	}
*/

	public String saveOrUpdate() {

		
		prodDAO.SaveOrUpdateProd(prodCatBean, prodBean);
		
		return SUCCESS;
		
		/*I am transferring the object reference of prodCatBean, prodBean to the DAO from the JSP. 
		 *The beans are populated in the Product JSP. 
		 */
	}

	public String Update() {
		
		prodCatBean.setProdCatId(prodCatId);
		System.out.println("The ProductCat ID is: "+prodCatId);
		prodCatBean.setProdType(prodType);
		System.out.println("The Product Category are: "+prodType);
		
		
		prodBean.setProdDetId(prodDetId);
		System.out.println("The ProductDetail ID is: "+prodDetId);
		
		//prodCatBean.setProductDetail(prodBean);
		/*prodBean.setSize(size);
		System.out.println("The ProductDetail size is: "+size);
		prodBean.setCurrency(currency);
		prodBean.setRegularPrice(regularPrice);
		prodBean.setProdInfo(prodInfo);*/
	
		prodBean.setProductCat(prodCatBean);
		
		
		prodDAO.UpdateProd(prodBean);
		
		return SUCCESS;
		
		/*I first need to set the Product Category ID before I pass it to the DAO, because after I click on submit it looses the ID.
		  The Product Type isn't necessary to set it in the Action Class, but it by doing this here i can use one method in the DAO for Saving and Updating.
		  I am currently receiving the old record and updated record after altering product.
		  Complaint: Hibernate: insert into product_detail, is the complaint currently(inserting instead of updating)
		  I solved this by declaring the productDetail ID.
		*/
	}

	/**
	 * To list all users.
	 * 
	 * @return String
	 */
	public String list() {
		prodList = prodDAO.listProd();
		return SUCCESS;
	}

	public String listCat() {

		prodCat = prodDAO.listProdCat();

		return SUCCESS;
	}

	/**
	 * To delete a user.
	 * 
	 * @return String
	 */
	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		prodDAO.deleteProd(Long.parseLong(request.getParameter("id")));

		/* The name of the id name in JSP must be the same as the one getting the parameters
		 * I use the following ID to delete a item: ProductDetail.prodDetId
		*/
		System.out.println("Deleting a product");
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		prodt = prodDAO.listUserById(Long.parseLong(request.getParameter("id")));
		

		/* The name of the id name in JSP must be the same as the one getting the parameters
		 * prodt is an object reference for productCategory, this will be used to display selected ID values in Update JSP
		*/
		
		return SUCCESS;
	}
	
	public void prepare() throws Exception{
		
		
		/*bikeCatList = new ArrayList<String>();
		
		bikeCatList.add("Mountain Bike");
		bikeCatList.add("Racing Bike");
		bikeCatList.add("BMX");
		
		prodList = prodDAO.listProd();
		
		//return SUCCESS;
*/	}
	
	/*public String display(){
		
		return NONE;
		
	}*/
	

	public ProductDetail getProdBean() {
		return prodBean;
	}

	public void setProdBean(ProductDetail prodBean) {
		this.prodBean = prodBean;
	}

	public List<ProductDetail> getProdList() {
		return prodList;
	}

	public void setProdList(List<ProductDetail> prodList) {
		this.prodList = prodList;
	}

	public ProductDAO getProdDAO() {
		return prodDAO;
	}

	public void setProdDAO(ProductDAO prodDAO) {
		this.prodDAO = prodDAO;
	}

	public void setProdType(String prodType) {
		System.out.println("The Product type is in the setter: " + prodType);
		this.prodType = prodType;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdCat(List<ProductCat> prodCat) {
		this.prodCat = prodCat;
	}

	public List<ProductCat> getProdCat() {
		return prodCat;
	}

	/*public void setProdt(ProductCat prodt) {
		this.prodt = prodt;
	}

	public ProductCat getProdt() {
		return prodt;
	}*/

	public void setProdCatId(long prodCatId) {
		this.prodCatId = prodCatId;
	}

	public long getProdCatId() {
		return prodCatId;
	}

	public void setProdCatBean(ProductCat prodCatBean) {
		this.prodCatBean = prodCatBean;
	}

	public ProductCat getProdCatBean() {
		return prodCatBean;
	}

	public long getProdDetId() {
		return prodDetId;
	}

	public void setProdDetId(long prodDetId) {
		this.prodDetId = prodDetId;
	}

	

	public long getProdId() {
		return prodId;
	}

	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public ProductDetail getProdt() {
		return prodt;
	}

	public void setProdt(ProductDetail prodt) {
		this.prodt = prodt;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	

	public void setP(List<String> p) {
		this.p = p;
	}

	public List<String> getP() {
		return p;
	}

}
