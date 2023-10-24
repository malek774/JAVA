<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>TVDB</title>
</head>
<body>
	<div class="container mt-5 d-flex flex-column">
		<h1>Edit Listing</h1>
		<div class="d-flex flex-column col-4 gap-2">
			<form:form class="d-flex flex-column gap-2" action="/listings/${listening.id}/update" method="POST" modelAttribute="listening">
				<input type="hidden" name="_method" value="PUT"/>
				<form:input type="hidden" path="poster" value="${listening.poster.id}"/>
				<div class="d-flex justify-content-between">
					<form:label path="address">Address</form:label>
					<form:input type="text" path="address"/>
				</div>
				<form:errors class="text-danger" path="address"/>
				
				<div class="d-flex justify-content-between">
					<form:label path="price">Price</form:label>
					<form:input type="number" path="price"/>
				</div>
				<form:errors class="text-danger" path="price"/>
				
<!-- 				<div class="d-flex justify-content-between"> -->
<%-- 					<form:label path="createdAt">Listing Date</form:label> --%>
<%-- 					<form:input type="date" path="createdAt"/> --%>
<!-- 				</div> -->
<%-- 				<form:errors class="text-danger" path="createdAt"/> --%>
				
				<input class="btn bg-info align-self-end col-3" type="submit" value="Update"/>
			</form:form>
			<a class="btn bg-info align-self-end col-3" href="/home">Cancel</a>
		</div>
		
		
	</div>
</body>
</html>