<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>Save Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vender</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>

			</thead>
			<tbody>
				<c:forEach items="${allExpense}" var="OneExpense">
					<tr>
						<td><a href="/expense/${OneExpense.id}"><c:out value="${OneExpense.name}" /></a></td>
						<td><c:out value="${OneExpense.vendor}" /></td>
						<td><c:out value="${OneExpense.amount}" /></td>
						<td><c:out value="${OneExpense.id}" /></td>
						<td><a href="/expense/${OneExpense.id}/edit">Edit</a>
							<form action="/expense/delete/${OneExpense.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input type="submit" value="Delete" class="btn btn-danger">
							</form></td>
					</tr>
				</c:forEach>
			</tbody>



		</table>




		<h1>Add an expense:</h1>
		<hr />
		<!--    Form to create a Expense -->
		<form:form action="/expense/new" method="post"
			modelAttribute="expense">
			<form:errors class="text-danger" path="*" />
			<p>
				<form:label path="name">Expense Name :</form:label>
				<form:input path="name" />
			</p>


			<p>
				<form:label path="vendor">Vendor :</form:label>
				<form:input type="text" path="vendor" />
			</p>

			<p>
				<form:label path="amount">Amount :</form:label>
				<form:input type="number" path="amount" />
			</p>

			<p>
				<form:label path="description">Description :</form:label>
				<form:input type="texteria" path="description" />
			</p>

			<button>Submit</button>
		</form:form>
	</div>
</body>
</html>