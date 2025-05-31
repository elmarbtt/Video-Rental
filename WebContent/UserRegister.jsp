<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>

<link rel="stylesheet" type="text/css" media="screen" href="images/Underground.css" />

</head>
<body>
<div id="wrap">
     <div id = "header">
     
     <ul>
        <li> <s:url id="homeURL" action="home"></s:url> 
				<s:a href="%{homeURL}"><span>Homepage</span></s:a></li>
			
                 <li><s:url id="prodURL" action="listProd"></s:url> 
				<s:a href="%{prodURL}"><span>Products</span></s:a></li>
                 
				
				
				
				 
				
				 
		</ul>		
	</div>			
				
				
  
           <div id="header-logo">			
			
			<div id="logo">User<span class="red">Registration</span></div>		
			
			<form method="post" class="search" action="#">
				<p><input name="search_query" class="textbox" type="text" />
  				<input name="search" class="searchbutton" value="Search" type="submit" /></p>
			</form>
						
		</div>

 	<div id="left">

<s:form action="saveOrUpdateUser">
	
		<s:hidden name = "id"/>
		<s:textfield name="empBean.firstName" label="First Name"/>
		<s:textfield name="empBean.lastName" label="Last Name"/>
		<s:textfield name="userBean.userName" label="User Name"/>
		<s:textfield name="userBean.password" label="Password"/>
		<s:textfield name="empBean.email" label="Please Enter Email Address"/>
		<s:select name="role" label="User Role"  
		          list="{'Manager','Clerk'}" headerKey=""
			headerValue="Select" label="Select a role"/>
		<s:select name="addrole" label="Add a additional role"  
		          list="{'Region Manager','Supervisor'}" headerKey=""
			headerValue="Select" label="Select a role"/>	
		<s:textfield name="empBean.workNo" label="Please Enter Work Number"/>	
		<s:textfield name="empBean.telNo" label="Please Enter Cellphone Number"/>	
		<s:textfield name="empBean.address" label="Please Enter Home Address"/>	
		<s:textfield name="empBean.city" label="Please Enter City"/>
		<s:textfield name="empBean.zipCode" label="Please Enter Zip Code"/>
		<s:select name="empBean.region" label="Select a Provice"  list="{'Western Cape','Gauteng','Eastern Cape'}" headerKey=""
			headerValue="Select" label="Select a Province"/>	
		<s:textarea name="empBean.resume" label="Please Enter Resume" />
		<s:textarea name="empBean.review" label="Employee Review" />
		
		
			
		
	
		<s:submit />
 
</s:form>
</div>
</div>

<s:if test="userList.size() > 0">
<h2>Employees</h2>
<table id="prod" border="1">
<tr>
			
			<th>First Name</th>
			<th>Last name</th>
			<th>UserName</th>
			<th>Email</th>
			<th>Work No.</th>
			<th>Tel No.</th>
			<th>Address</th>
			<th>City</th>
			<th>Zip Code</th>
			<th>Region</th>
			<th>Resume</th>
			<th>Review</th>
		</tr>
		<s:iterator value="userList" var="users">
			<tr>
				<!-- When I want to display the information, it currently displays no information
				     in the table.
				     
				     You have to reference the table and parameter it must fetch the data form
				     to populate the data grid.(empBean wont work, but Employee will)
				 -->
				 
				 <!-- <td><s:property value="getUser2().getEmployee().getFirstName()" /></td> -->
				<td><s:property value="Employee.firstName" /></td>
				<td><s:property value="Employee.lastName" /></td>
				<td><s:property value="userName" /></td>
				<td><s:property value="Employee.email" /></td>
				<td><s:property value="Employee.workNo" /></td>
				<td><s:property value="Employee.telNo" /></td>
				<td><s:property value="Employee.address" /></td>
				<td><s:property value="Employee.city" /></td>
				<td><s:property value="Employee.zipCode" /></td>
				<td><s:property value="Employee.region" /></td>
				<td><s:property value="Employee.resume" /></td>
				<td><s:property value="Employee.review" /></td>
				<td><s:url id="editURL" action="editUser">
					<s:param name="id" value="%{userId}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="removeUser">
					<s:param name="id" value="%{userId}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
				<td><s:url id="roleURL" action="viewRole">
				<s:param name="id" value="%{userId}"></s:param>
				</s:url> <s:a href="%{roleURL}">View Roles</s:a></td>
				
				
			</tr>
		</s:iterator>
	</table>
	
</s:if>
</body>
</html>