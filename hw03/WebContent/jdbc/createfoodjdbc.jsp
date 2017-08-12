<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/app.css' />">
<title>New Food Item</title>
</head>
<body>

<h2>Add New Food</h2>

<section class="newItem">
	<form method="POST">
	
	Food Name:
	<br />
	<input name="name" type="text">
	<br />
	Image URL:
	<br />
	<input name="url" type="text">
	<br />
	Food Description:
	<br />
	<textarea name="description"></textarea>
	
	<br />
	Price:
	<br />
	<input name="price" type="text">
	<br />
	<button class='add'>Add</button>
	</form>
	</section>
	

</body>
</html>