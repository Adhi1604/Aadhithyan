<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="2" cellspacing="2" border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Color</th>
<th>Price</th>
</tr>
<c:forEach var="product" items="${products}">
<tr>
<td>${product.productid}</td>
<td>${product.productname}</td>
<td>${product.productcolor}</td>
<td>${product.productprice}</td>
<td><a href="${pageContext.request.contextPath}/cart? &action=add&product_id=${product.productid}">Add to cart</a></td>
</tr>
</c:forEach>
</table>
<br/>
 <a href="${pageContext.request.contextPath }/cart">Go To Cart</a>
<br/>	
<br/>
 <a href="${pageContext.request.contextPath }/views/home.jsp">Home</a>
<br/>	
</body>
</html>