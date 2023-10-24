<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>View Listing</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1><c:out value="${listening.address}"/></h1>
			<a href="/home">Dashboard</a>
		</div>
		
		<hr />
		
		<div class="col-8 m-auto">
			<h3>Address: <span class="text-info"><c:out value="${listening.address}"/></span></h3>
			<h3>Listening Date: <span class="text-info"><c:out value="${listening.createdAt}"/></span></h3>
			<h3>Price: <span class="text-info"><c:out value="${listening.price}"/></span></h3>
		</div>
		
		<hr />
		

		<c:if test="${listening.poster.id == userId}">
			<div class="d-flex justify-content-end">
				<a class="btn bg-warning col-2" href="/listings/${listening.id}/edit">Edit</a>
				
				<form action="/listings/${listening.id}/delete" method="POST">
			<input type="hidden" name="_method" value="DELETE"/>
			<input class="btn bg-danger text-white" type="submit" value="Delete"/>
		</form>
			</div>
		
		
		
		</c:if>

		
	</div>
</body>
</html>