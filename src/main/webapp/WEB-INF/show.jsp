<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Display Book</title>
</head>

<body>


<div class="text-center">

 <h1>Here's Your Book!</h1>
 
 </div>
 
 
 
 
<div class="d-flex justify-content-center">

<form class="bg-dark w-25 p-3 text-white">
  
  
  
 <h1> <c:out value="${books.title}"></c:out> </h1>
   
    <h2> <c:out value="${books.description}"></c:out>  </h2>
  
  <h2>    <c:out value="${books.language}"></c:out>   </h2>
  
  <h2>    <c:out value="${books.numberOfPages}"></c:out>   </h2>
  
  
  
  
</form>



</div>

<div class="d-flex justify-content-center">
<a href="/books">Go Back</a>
</div>

</body>
</html>