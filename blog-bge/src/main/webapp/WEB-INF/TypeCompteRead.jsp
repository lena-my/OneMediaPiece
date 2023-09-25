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
<title>Liste de types de compte</title>
</head>
<body>
	<div class="container">
	
		<jsp:include page="Header.jsp"></jsp:include>
		
	<form method="post" action="/blog-bge/TypeCompteRead">

		<table>
			<tr>
				<th></th>
				<th>Id</th>
				<th>Label</th>
				<th></th>
			</tr>

			<c:forEach items = "${ typeComptes }" var = "typeCompte">	
				<tr>
					<td><input type="hidden" name="id"
						value="${ typeCompte.idTypeCompte }"></td>
					<td><c:out value="${ typeCompte.idTypeCompte }" /></td>
					<td><c:out value="${ typeCompte.label }" /></td>
					<td><a href="TypeCompteUpdate?id=${ typeCompte.idTypeCompte }">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>

	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>