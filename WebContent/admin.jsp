<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>


<h1>Access Granted</h1>


		
        <h2>Hello ${pageContext.request.userPrincipal.name}</h2>  
        <a href="j_spring_security_logout">Logout</a>
    </body>
</html>	
			
	

