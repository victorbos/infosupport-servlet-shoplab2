<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="hero-unit">
		<h1>Buy a product...</h1>
	</div>
	<div class="span12">
		<c:forEach items="${products}" var="product"> 
			<div class="span3 thumbnail">
				<form action="basket" method="post">
                    <input type="hidden" name="productId" value="${product.id}">
                    <img src="img/${product.image}">
                    <h3>${product.name}</h3>
                    <p>Price: EUR ${product.price}</p>
                    <input type="submit" value="Koop!" class="button btn-primary">
                </form>
			</div>
		</c:forEach>
	</div>
</body> 
</html>