<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/app.css' />">
<title>Inventory</title>
</head>
<body>

<h2>Existing Food Items</h2>

	<table>
		<tr>
			<th>Created</th>
			<th>Item</th>
			<th>Actions</th>
		</tr>
		 <c:forEach items="${list}" var="food">
		<tr>
			<td><%=new java.util.Date() %></td>
			<td><center><img src ='${food.imageUrl}' alt='image' style='width:50px;height:50px' /><br />${food.name}</center></td>
			<td><button>Delete</button></td>
		
		</tr>
		</c:forEach>
	</table>
	<br />
	<a href='create/'>Add Food Item</a>
	

</body>
</html>