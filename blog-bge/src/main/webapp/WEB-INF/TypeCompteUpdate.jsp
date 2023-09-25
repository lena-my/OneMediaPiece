<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Modifier le type de compte</title>
</head>
<body>
	<div class="container">
	
		<jsp:include page="Header.jsp"></jsp:include>
	
	<h3>Modification du type de compte</h3>

	
		<form method="post" action="/blog-bge/TypeCompteUpdate">
			<fieldset>	
		
			<label for="id">Id ${ typeCompte.idTypeCompte }</label> <br /> 
			<input type="hidden" id="id" name="id" value="${ typeCompte.idTypeCompte }" /> <br />
			
			<label for="label">Label</label> <br /> 
			<input type="text" id="label" name="label" value="${ typeCompte.label }"/> <br />
				
			<input type="submit" value="Ok" /> <br />
		</fieldset>
		</form>
		
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>