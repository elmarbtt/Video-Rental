<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Product Detail Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>

<link rel="stylesheet" type="text/css" media="screen" href="images/Underground.css" />

</head>
<body>

<div id="wrap">
    
    <div id = "header">
<s:url id="regisURL" action="listUser">
</s:url> <s:a href="%{regisURL}"><span>Home Page</span></s:a>

		
		</div>
		
		<div id="header-logo">			
			
			<div id="logo">Products</div>		
			
			<form method="post" class="search" action="#">
				<p><input name="search_query" class="textbox" type="text" />
  				<input name="search" class="searchbutton" value="Search" type="submit" /></p>
			</form>
						
		</div>
			
<div id="left">		
<s:form action="saveOrUpdateProd">
	
		<s:hidden name = "id"/>
		<s:textfield name="prodBean.prodName" label="Product Name"/>
		<s:select name="prodCatBean.prodType" label="Category" list="{'Action','Adventure','Comedy'}" headerKey=""
			headerValue="Select" label="Select a bike type"/>
		<s:select name="prodBean.prodDesc" label="Picture"  list="{'Excalibar.jpg','Rockey.jpg','Raleigh.jpg'}" headerKey=""
			headerValue="Select" label="Select a picture"/>	
		<s:select name="prodBean.currency" label="currency"  list="{'R','$'}" headerKey=""
			headerValue="Select" label="Select a currency"/>
		<s:textfield name="prodBean.regularPrice" label="Price" />
		<s:textarea name="prodBean.prodInfo" label="Product Information" />
		<s:textfield name="productBean.qty" label="Quantity"/>
		
		
			
		
	
		<s:submit />
 
</s:form>
</div>
</div>

<s:if test="prodList.size() > 0">
<h2>Products</h2>
<table id="prod" border="1">

      
<tr>
			<th>#</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Currency</th>
			<th>Price</th>
			<th>Product Information</th>
			<th>Quantity</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="prodList" var="prod">
			<tr>
				<td><IMG width="100px" height="100px" src="images/<s:property value="prodDesc" />"></td>
				<td><s:property value="prodName" /></td>
				<td><s:property value="ProductCat.prodType" /></td>
				<!-- I swapped these two fields -->
				<td><s:property value="currency" /></td>
				<td><s:property value="regularPrice" /></td>
				<td><s:property value="prodInfo" /></td>
				<td><s:property value="Product.qty" /></td>
				<td><s:url id="editURL" action="editProd">
					<s:param name="id" value="%{prodDetId}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="removeProd">
					<s:param name="id" value="%{prodDetId}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
	
</s:if>
</body>
</html>