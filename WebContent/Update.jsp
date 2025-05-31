<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Detail Page</title>
<s:head />

<link rel="stylesheet" type="text/css" media="screen" href="images/Underground.css" />

</head>
<body>
<div id="wrap">
    
    <div id = "header">
<s:url id="prodURL" action="listProd">
</s:url> <s:a href="%{prodURL}"><span>Back</span></s:a>

		
		</div>
		
		<div id="header-logo">			
			
			<div id="logo">Update Product</div>		
			
			
						
		</div>
		
<div id="left">

<s:form action="UpdateProd">
	<s:push value="prodt">
	
		<s:hidden name = "prodCatId" value="%{ProductCat.prodCatId}"/>
		<s:hidden name = "prodDetId"/>
		
		<s:textfield name="prodBean.prodName" label="Product Name" value="%{prodName}"/>
		<s:select name="prodType" label="Category"  list="{'Action','Adventure','Comedy'}" headerKey=""
			headerValue="Select" label="Select a bike type" value="%{ProductCat.prodType}"/>
			<s:select name="prodBean.prodDesc" label="Picture"  list="{'Excalibar.jpg','Rockey.jpg','Raleigh.jpg'}" headerKey=""
			headerValue="Select" label="Select a picture"/>	
		<s:select name="prodBean.currency" label="currency"  list="{'R','$'}" headerKey=""
			headerValue="Select" label="Select a currency" value="%{currency}"/>
		<s:textfield name="prodBean.regularPrice" label="Price" value="%{regularPrice}"/>
		<s:textarea name="prodBean.prodInfo" label="Product Information" value="%{prodInfo}"/>
		<s:textfield name="qty" label="Quantity" value="%{Product.qty}"/>
		
		<s:submit />
  </s:push>
</s:form>
</div>
</div>

<s:if test="prodCat.size() > 0">
<h2>Products</h2>
<table id="prod" border="1">
<tr>
			<th>Product Name</th>
			<th>Category</th>
			<th>Currency</th>
			<th>Price</th>
			<th>Product Information</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="prodCat" var="prod">
			<tr>
				
				<td><s:property value="productDetail.prodName" /></td>
				<td><s:property value="prodType" /></td>
				<td><s:property value="productDetail.currency" /></td>
				<td><s:property value="productDetail.regularPrice" /></td>
				<td><s:property value="productDetail.prodInfo" /></td>
				<td><s:url id="editURL" action="editProd">
					<s:param name="id" value="%{prodCatId}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteProd">
					<s:param name="id" value="%{productDetail.prodDetId}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
	
</s:if>

</body>
</html>