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
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	 <form:form action="/ninjas" method="post" modelAttribute="ninja">
   <form:errors class="text-danger" path="*"/>
   
   <!--      All the Dojos -->
    <form:select path="dojo">
    	
	    <c:forEach items="${ListDojos}" var ="dojo">
	    
	    <form:option value="${dojo.id }">${dojo.name }</form:option>
	    </c:forEach>
    </form:select>
    
    <p>
        <form:label path="firstname">First Name:</form:label>
        <form:input path="firstname"/>
    </p>


    <p>
        <form:label path="lastname">Last Name:</form:label>
        <form:input path="lastname"/>
    </p>   
    
    <p>
        <form:label path="age">Age:</form:label>
        <form:input type="number" path="age"/>
    </p>   

    
    
    <button>Create</button>
</form:form>    
</body>
</html>