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
<s:url id="regisURL" action="listUser">
</s:url> <s:a href="%{regisURL}"><span>Back</span></s:a>

		
		</div>
		<div id="header-logo">			
			
			<div id="logo">Update User</div>		
			
			
						
		</div>
		
<div id="left">	


<s:form action="UpdateUser">

	<s:push value = "usert">
	
	  
		<s:hidden name = "empId" value="%{Employee.empId}"/>
		<s:hidden name = "userId" />
		<!--Need theses ID's to update the users details.-->
		<!--Currently the ID's are zero, when it goes to the UserAction class, the id's were spelled wrong in Action class-->
		
		<s:textfield name="firstName" label="First Name" value="%{Employee.firstName}"/>
		<s:textfield name="lastName" label="Last Name" value="%{Employee.lastName}"/>
		<s:textfield name="userBean.userName" label="User Name" value="%{userName}"/>
		<s:textfield name="userBean.password" label="Password" value="%{password}"/>
		<s:textfield name="email" label="Please Enter Email Address" value="%{Employee.email}"/>
		<s:textfield name="workNo" label="Please Enter Work Number" value="%{Employee.workNo}"/>	
		<s:textfield name="telNo" label="Please Enter Cellphone Number" value="%{Employee.telNo}"/>	
		<s:textfield name="address" label="Please Enter Home Address" value="%{Employee.address}"/>	
		<s:textfield name="city" label="Please Enter City" value="%{Employee.city}"/>
		<s:textfield name="zipCode" label="Please Enter Zip Code" value="%{Employee.zipCode}"/>
		<s:select name="region" label="Select a Provice"  list="{'Western Cape','Gauteng','Eastern Cape'}" headerKey=""
			headerValue="Select" label="Select a Province" value="%{Employee.region}"/>	
		<s:textarea name="resume" label="Please Enter Resume" value="%{Employee.resume}"/>
		<s:textarea name="review" label="Employee Review" value="%{Employee.review}"/>
		
		
			
		
	
		<s:submit />
 </s:push>
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
				<td><s:property value="Employee.firstName" /></td>
				<!-- Not showing first name in table and populating form with data  -->
				<td><s:property value="Employee.lastName" /></td>
				<td><s:property value="User.userName" /></td>
				<td><s:property value="Employee.email" /></td>
				<td><s:property value="Employee.workNo" /></td>
				<td><s:property value="Employee.telNo" /></td>
				<td><s:property value="Employee.address" /></td>
				<td><s:property value="Employee.city" /></td>
				<td><s:property value="Employee.zipCode" /></td>
				<td><s:property value="Employee.region" /></td>
				<td><s:property value="Employee.resume" /></td>
				<td><s:property value="Employee.review" /></td>
				<td><s:url id="editURL" action="editProd">
					<s:param name="id" value="%{prodDetId}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteProd">
					<s:param name="id" value="%{prodDetId}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
				<td><s:url id="roleURL" action="viewRole">
				</s:url> <s:a href="%{roleURL}">View Roles</s:a></td>
			</tr>
		</s:iterator>
	</table>
	
</s:if>
</body>
</html>