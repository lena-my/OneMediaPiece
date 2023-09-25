<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suppression de compte</title>
</head>
<body>
	
	<form method="post" action="/blog-bge/CompteDelete">

		<table>
			<tr>
				<th></th>
				<th>Id</th>
				<th>Pseudonime</th>
				<th>E-mail</th>
			</tr>

			<c:forEach items="${ comptes }" var="compte">
				<tr>
					<td><input type="checkbox" name="id" value="${ compte.idCompte }"></td>
					<td><c:out value="${ compte.idCompte }" /></td>
					<td><c:out value="${ compte.pseudonime }" /></td>
					<td><c:out value="${ compte.email }" /></td>
				</tr>
			</c:forEach>

		</table>
		
		 <input type="submit" value="Ok" /> <br />

	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>