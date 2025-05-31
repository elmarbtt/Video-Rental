<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Roles</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>


<h2>Employees</h2>
<table id="prod" border="1">
<tr>
			
			<th>First Name</th>
			<th>Last name</th>
			<th>UserName</th>
			<th>Role</th>
			<th>Additional Role</th>
			
			
		</tr>
		
		<s:iterator value="roleList" var="users">
			<tr>
				<!-- When I want to display the information, it currently displays no information
				     in the table.
				     
				     You have to reference the table and parameter it must fetch the data form
				     to populate the data grid.(empBean wont work, but Employee will)
				 -->
			<!--It didn't display any values until I put in the user_role_ID, but when I removed it it still displayed the values again   -->
				<td><s:property value="getUser2().getEmployee().getFirstName()" /></td>
				<td><s:property value="getUser2().getEmployee().getLastName()" /></td>
				<td><s:property value="getUser2().getUserName()" /></td>
				<td><s:property value="getRole2().getRole()" /></td>
				<td><s:property value="getRole2().getRole()" /></td>
				<td><s:url id="editURL" action="editProd">
					<s:param name="id" value="%{prodDetId}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteProd">
					<s:param name="id" value="%{prodDetId}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>

	</table>
	

</body>
</html>