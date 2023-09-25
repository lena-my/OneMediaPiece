<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suppression de commentaire</title>
</head>
<body>

	
	<form method="post" action="/blog-bge/CommentaireDelete">

		<table>
			<tr>
				<th></th>
				<th>Id</th>
				<th>Contenu</th>
			</tr>

			<c:forEach items = "${ commentaires }" var = "commentaire">
				<tr>
					<td><input type="checkbox" name="id"
						value="${ commentaire.idCommentaire }"></td>
					<td><c:out value="${ commentaire.idCommentaire }" /></td>
					<td><c:out value="${ commentaire.contenu }" /></td>
				</tr>
			</c:forEach>

		</table>
		
		 <input type="submit" value="Ok" /> <br />

	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>