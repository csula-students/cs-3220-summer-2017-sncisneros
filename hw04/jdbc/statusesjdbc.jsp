<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri = "/WEB-INF/admin-header.tld" prefix = "cs3220" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/app.css' />">
<title>Order Status</title>
</head>
<cs3220:custHeader title="The Good Food"/>
<body bgcolor="lightgray">

<h2>Order Status</h2>

<table>
	<tr>
		<th>Created</th>
		<th>Item ID</th>
		<th>Name</th>
		<th>Status</th>
	</tr>
	<c:forEach items="${list}" var="order">
	<tr>
		<td>${order.created}</td>
		<td>${order.itemId}</td>
		<td>${order.custName}</td>
		<td>${order.statuses}</td>
	</tr>
	</c:forEach>
</table>

<footer>
			<div class="container">
				&copy; 2017 The Good Food, Inc. All Rights Reserved
			</div>
		</footer>

</body>
</html>