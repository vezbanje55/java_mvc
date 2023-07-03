<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alien JSP</title>
</head>
<body>
	<br><br><p>Prost primer. Uneti Id i Name.<p>
	<form action="addAlien">
		ID: <input type="text" name="aid"><br>
		Name: <input type="text" name="aname"><br>
		<input type="submit"><br>
	</form>
	
	
	<br><br><p>Prost primer. Retrieve by Id.<p>
	<form action="getAlien">
		ID: <input type="text" name="aid"><br>
		<input type="submit"><br>
	</form>
</body>
</html>