<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
	<link rel="stylesheet" href="style.css"/>
	<title>Login Form</title>
	<s:head/>
</head>
<body>
	<div align="center">
		<h2>Login</h2>
		<s:form action="loginAction" class="loginform">
			<s:textfield name="userName" label="User Name" class="formTextField"/>
			<s:password name="password" label="password" class="formTextField"/>
			<s:submit value="submit" class="actionBtn"/>
		</s:form>
	</div>
</body>
</html>