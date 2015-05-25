<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Shopping basket</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="hero-unit">
		<h1>Buy a product...</h1>
	</div>

	<table class="table">
		<tr>
			<th>Product</th>
            <th>Prijs</th>
			<th>Aantal</th>
			<th>Subtotaal</th>
		</tr>
		<c:forEach var="productBasketItem" items="${sessionScope.shoppingBasket.items}">
			<tr>
                <td>${productBasketItem.product.name}</td>
                <td>${productBasketItem.product.price}</td>
                <td>${productBasketItem.amount}</td>
                <td>${productBasketItem.amount * productBasketItem.product.price}</td>
            </tr>
		</c:forEach>
	</table>
	
</body> 
</html>