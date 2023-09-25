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
<title>Demandes de suppression totale des données</title>
</head>
<body>

<div class="container">

	<jsp:include page="Header.jsp"></jsp:include>
	
	<h2>Demandes des suppression totale des données de compte</h2>
	
	
	
	<form method="post" action="/blog-bge/CompteDeleteSuppressionTotale" class="innerContainer">
		<p>Cochez les cases des comptes à supprimer:</p>
		<table>
			<tr>
				<th></th>
				<th>Id</th>
				<th>Pseudonime</th>
				<th>E-mail</th>
			</tr>

			<c:forEach items="${comptes}" var="compte">
				<br>
				<c:if test="${compte.supressionDonnee}">	
					<tr>
						<td><input type="checkbox" name="id" value="${ compte.idCompte }"></td>
						<td>${ compte.idCompte }</td>
						<td>${ compte.pseudonime }</td>
						<td>${ compte.email }</td>
					</tr>
				</c:if>
			</c:forEach>

		</table>
		
		 <input type="submit" value="Supprimer" /> <br />

	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</div>	
	

</body>
</html>