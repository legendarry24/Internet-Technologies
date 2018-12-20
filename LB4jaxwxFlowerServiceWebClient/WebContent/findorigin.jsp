<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find by origin</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
	<div>
		<form action="findorigin" method="post">
			<label for="pattern">Origin: </label> 
			<input type="text" name="pattern" autofocus="autofocus" required="required"/> 
			<input type="submit" value="Find" />
		</form>
	</div>
</body>
</html>