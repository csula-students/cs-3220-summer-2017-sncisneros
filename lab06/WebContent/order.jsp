<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri = "WEB-INF/admin-header.tld" prefix = "cs3220" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/app.css' />">
<title>Shopping Cart</title>
</head>
<cs3220:custHeader title="The Good Food"/>
<body bgcolor="lightgray">

<h2>Your Cart</h2>

<table>
	<tr>
		<th>Item</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${newCustItems}" var="item">
	<tr>
		<td>${item.name}<br/><img src="${item.imageUrl}" style="width:50px;height:50px"></td>
		<td>${item.price}</td>
		<td>1</td>
		<td><form method='get'><button name="remove" value="${item.getId()}">Delete</button></form></td>
	</tr>
	</c:forEach>
	
</table>

<form method="post">
	<button>Checkout</button>
</form>

	<footer>
	<div class="container">&copy; 2017 The Good Food, Inc. All Rights
		Reserved</div>
	</footer>

</body>
</html>