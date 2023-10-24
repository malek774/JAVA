<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>House Hunter dashboard</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Welcome, <c:out value="${user.userName}"/></h1>
			<a href="/logout">Logout</a>
		</div>
		<hr/>
		<div class="col-8 m-auto">
			<table class="table table-striped text-center">
				<thead>
					<tr>
						<th>Address</th>
						<th>listed On</th>
						<th>Added By</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listening" items="${ListeningList}">
						<tr>
							<td><a href="/listing/${listening.id}">${listening.address}</a></td>
							<td>${listening.createdAt}</td>
							<td>${listening.poster.userName}</td>
							<td>${listening.price} $</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a class="btn bg-info border-rounded" href="/listing/new">Add Listing</a>
		</div>
	</div>
</body>
</html>