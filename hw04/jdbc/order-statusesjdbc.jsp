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
<cs3220:header title="The Good Food"/>
<body bgcolor="lightgray">

<h2>Order Statuses - UPDATE</h2>

<table>
	<tr>
		<th>Created</th>
		<th>Item</th>
		<th>Name</th>
		<th>Status</th>
	</tr>
	<c:forEach items="${list}" var="order">
	<tr>
		<td>${order.created}</td>
		<td>${order.itemId}</td>
		<td>${order.custName}</td>
		<td><form name="status" method="get"><select>
				<option value="IN_PROGRESS">IN_PROGRESS</option>
				<option value="IN_QUEUE">IN_QUEUE</option>
				<option value="COMPLETED">COMPLETE</option>
			</select>
			<input type="submit" value="Status Change">
			</form></td>
	</tr>
	</c:forEach>
</table>
					
		</tr>
	
	</table>
	
	

</body>
</html>