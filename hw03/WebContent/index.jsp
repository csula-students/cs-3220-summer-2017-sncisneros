<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@ taglib uri = "WEB-INF/admin-header.tld" prefix = "cs3220" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/app.css' />">
<title>Menu</title>
<cs3220:custHeader title="The Good Food"/>
</head>
<body>

<main>
		<section class="container">
			<h2>Food Menu</h2>
	
			<section class="item">
	
				<table>
		<tr>
			<th>Item</th>
			<th>Description</th>
			<th>Price</th>
			<th>Add Item</th>
		</tr>
		 <c:forEach items="${foods}" var="food">
		<tr>
			<td><center><img src ='${food.imageUrl}' alt='image' style='width:50px;height:50px' /><br />${food.name}</center></td>
			<td>${food.description}</td>
			<td>$ ${food.price}
			<td><form method='get'><button name="add" value="${food.getId()}">Add To Cart</button></form></td>
		
		</tr>
		</c:forEach>
	</table>
	
	</section>

</body>
</html>