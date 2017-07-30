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

<h2>Order Statuses</h2>

<table cellspacing="15px">
		<tr>
			<th>Created</th>
			<th>Item</th>
			<th>Customer</th>
			<th>Status</th>
		</tr>
		<tr>
			<td>July 12, 2017</td>
			<td><center><img src="http://toriavey.com/images/2013/08/Hamburger-History-1.jpg" alt='image' style='width:50px;height:50px' /><br /> Hamburger</center></td>
			<td>Brittany P.</td>
			<td><select>
				<option value="pending">PENDING</option>
				<option value="in-queue">IN QUEUE</option>
				<option value="completed">COMPLETE</option>
			</select></td>		
		</tr>
	
	</table>

</body>
</html>