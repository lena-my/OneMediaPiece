<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Suppression de  type compte</title>
</head>
<body>
	<div class="container">
	
		<jsp:include page="Header.jsp"></jsp:include>
	
	<form method="post" action="/blog-bge/TypeCompteDelete">

		<table>
			<tr>
				<th></th>
				<th>Id</th>
				<th>Type de compte</th>
				<th>Modifier</th>
			</tr>

			<c:forEach items="${ typeComptes }" var="typeCompte">
				<tr>
					<td><input type="radio" name="id" value="${ typeCompte.idTypeCompte }" onclick = "montrerChamps"></td>
					<td><c:out value="${ typeCompte.idTypeCompte }" /></td>
					<td><c:out value="${ typeCompte.label }" /></td>
					<td><textarea name="label" rows="4" cols="50"></textarea></td>
				</tr>
			</c:forEach>

		</table>
		
		 <input type="submit" value="Ok" /> <br />

	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
	</div>
</body>
</html>