<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<!--    Form to Edit a Expense -->
		<form:form action="/expense/${OneExpense.id}/edit" method="post"
			modelAttribute="expense">
			<input type="hidden" name="_method" value="put">
			
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
				<form:label path="description">Amount</form:label>
				<form:input type="texteria" path="description" />
			</p>

			<button>Update</button>
		</form:form>
</body>
</html>