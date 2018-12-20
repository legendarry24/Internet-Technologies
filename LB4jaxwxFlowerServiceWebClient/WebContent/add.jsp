<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of flowers</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
 	<div>
 		<form action="add" method="post">
 			<label for="name">Name: </label>
 			<input type="text" name="name" />
 			
 			<label for="origin">Origin: </label>
 			<input type="text" name="origin" />
 			
 			<label for="soil">Soil: </label>
 			<input type="text" name="soil" />
 			
<!--  			<label for="stalkColor">StalkColor: </label>
 			<input type="text" name="stalkColor" />
 			
 			<label for="colorOfLeaves">ColorOfLeaves: </label>
 			<input type="text" name="ColorOfLeaves" />
 			
 			<label for="averagePlantSize">AveragePlantSize: </label>
 			<input type="number" name="averagePlantSize" min="0" />
 			
 			<label for="temperature">Temperature: </label>
 			<input type="number" name="temperature" min ="0" />
 			
 			<label for="watering">Watering: </label>
 			<input type="number" name="watering" min="0" />
 			
 			<label for="lighting">Lighting: </label>
 			<input type="text" name="lighting" />
 			
 			<label for="lighting">Lighting: </label>
 			<input type="text" name="lighting" /> -->
 			
 			<label for="multipling">Multipling: </label>
 			<input type="text" name="multipling" />
 			
 			<label for="price">Price: </label>
 			<input type="number" name="price" min="0.0" step="0.1"/>
 			
 			<input type="submit" value="Add" />
 		</form>
 	</div>
</body>
</html>