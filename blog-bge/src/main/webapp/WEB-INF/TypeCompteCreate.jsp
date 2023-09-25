<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Nouveau type de compte</title>
</head>
<body>
	<div class="container">
	
		<jsp:include page="Header.jsp"></jsp:include>

	<form method="post" action="/blog-bge/TypeCompteCreate">
		<fieldset>
		 
  			<label for="label">Nouveau type de compte</label><br>
			<input type="text" id="label" name="label" value="">
		

			<input type="submit" value="Ok" /> <br />
		
		</fieldset>

	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
	</div>
	
</body>
</html>