<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@ taglib uri = "WEB-INF/admin-header.tld" prefix = "cs3220" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/app.css' />">
<title>Order Status</title>
</head>
<cs3220:header title="The Good Food"/>
<body bgcolor="lightgray">

<h2>Order Statuses - UPDATE</h2>

<table>
	<tr>
		<th>Created</th>
		<th>Items</th>
		<th>Name</th>
		<th>Status</th>
	</tr>
	<c:forEach items="${orders}" var="order">
	<tr>
		<td>${order.created}</td>
		<td><c:forEach items="${order.items}" var="items">
		<center>${items.name}<br/><img src="${items.imageUrl}" style="width:50px;height:50px"></center>
		</c:forEach></td>
		<td>${order.custName}</td>
		<td><form name="status" method="get" action="#"><select>
				<option value="pending">IN_PENDING</option>
				<option value="in-queue">IN_QUEUE</option>
				<option value="completed">COMPLETE</option>
			</select>
			</form></td>
	</tr>
	</c:forEach>
</table>
					
		</tr>
	
	</table>
	
	<button>Update</button>

</body>
</html>