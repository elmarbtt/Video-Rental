<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
    <body>
        <h1>Struts2 - Spring Security Demo</h1> 
        <s:if test="%{#parameters.error != null}">
            <div style="color: red">Invalid User</div>
        </s:if>
        <s:form name="loginForm" action="j_spring_security_check" method="post">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </body>
</html>