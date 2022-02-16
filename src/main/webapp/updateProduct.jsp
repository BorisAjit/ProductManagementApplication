<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
	<link rel="stylesheet" href="style.css"/>
	<title>Update Product Form</title>
	<s:head/>
</head>
<body>
	<div align="center">
		<h2>Update Product</h2>
		<s:form action="updateAction" class="formTable">
			<s:textfield name="productId" label="Product Id" readonly="true" class="formTextField"/>
			<s:textfield name="productName" label="Product Name" class="formTextField"/>
			<s:textfield name="productCategory" label="Product Category" class="formTextField"/>
			<s:textfield name="productPrice" label="Product Price" class="formTextField"/>
			<s:submit value="Update Product" class="actionBtn"/>
		</s:form>
	</div>
</body>
</html>