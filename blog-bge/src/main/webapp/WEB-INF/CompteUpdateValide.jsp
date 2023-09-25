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
<title>Comptes à valider</title>
</head>
<body>
<div class="container">
	
	<jsp:include page="Header.jsp"></jsp:include>
	
	<h2>Comptes en attente de validation</h2>
	
	<form method="post" action="/blog-bge/CompteUpdateValide" class="innerContainer">
	
		<table>
		
			<tr>
				<th>Valider</th>
				<th>Id</th>
				<th>Pseudonime</th>
				<th>E-mail</th>
				<th></th>
			</tr>

			<c:forEach items = "${ comptes }" var = "compte">	
			
				<!--  show the "comptes non validés" -->
				<c:if test="${ compte.valide == false }">
					
					<tr>
						<td><input type="checkbox" name="id" value="${ compte.idCompte }"></td>
						<td><c:out value="${ compte.idCompte }" /></td>
						<td><c:out value="${ compte.pseudonime }" /></td>
						<td><c:out value="${ compte.email }"></c:out></td>
					</tr>
					
				</c:if>
				
			</c:forEach>
			
		</table>
		 
		 <input type="submit" value="Valider" /> <br />
	
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</div>
</body>
</html>