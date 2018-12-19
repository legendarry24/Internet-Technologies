<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of flowers</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
 	<c:choose>
 	<c:when test="${empty flowers }">
		<h2>No flowers found</h2>
 	</c:when>
	<c:otherwise>
	<table class="brd">
	<thead class="tabhead">
		<colcolgroup class="left"/>
		<colcolgroup class="left"/>
		<colcolgroup class="left"/>
		<colcolgroup class="right"/>
		<colcolgroup class="right"/>
		<colcolgroup class="left"/>
		<tr>
			<th class="brd">Name</th>
			<th class="brd">Origin</th>
			<th class="brd">Soil</th>
			<th class="brd">Multipling</th>
			<th class="brd">Price</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="flower" items="${flowers }">
		<tr>
			<td class="brd">${flower.name }</td>
			<td class="brd">${flower.origin }</td>
			<td class="brd">${flower.soil }</td>
			<td class="brd">${flower.multipling }</td>
			<td class="brd right">${flower.price }</td>
			<td class="brd"><form action="delete" method="post">
				<input type="hidden" name="id" value="${flower.id }">
				<input type="submit" value="Delete">
			</form> </td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</c:otherwise>
	</c:choose>
</body>
</html>