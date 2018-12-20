<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:when test="${not empty errorMsg }">
			<h2>${errorMsg }</h2>
		</c:when>
		<c:otherwise>
			<ul>
				<li>${flower.name }</li>
				<li>${flower.origin }</li>
				<li>${flower.soil }</li>
<%-- 				<li>${flower.skalkColor }</li>
				<li>${flower.colorOfleaves }</li>
				<li>${flower.averagePlantSize }</li>
				<li>${flower.temperature }</li>
				<li>${flower.watering }</li>
				<li>${flower.lighting }</li> --%>
				<li>${flower.multipling }</li>
				<li>${flower.price }</li>
			</ul>
		</c:otherwise>
	</c:choose>

	<!-- Due PRG pattern this page can be requested as get method only -->
	<!-- if was any error put it into html (see: errorMsg) and remove it from session -->
	<%
		session.removeAttribute("errorMsg");
	%>
	<!-- Put flower into html and remove it from session -->
	<%
		session.removeAttribute("flower");
	%>
</body>
</html>