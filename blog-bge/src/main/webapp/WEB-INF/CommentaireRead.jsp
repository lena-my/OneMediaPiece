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
<title>Liste de commentaires</title>
</head>
<body>
	<div class="container">
		
		<form method="post" action="/blog-bge/CommentaireRead" class="innerContainer">
	
		
			<c:forEach items = "${ commentaires }" var = "commentaire">	
				<p>Id: <c:out value="${ commentaire.idCommentaire }" /></p>
				<input type="hidden" name="id" value="${ commentaire.idCommentaire }">

				<p>Pseudonime: value="${ commentaire.compte.pseudonime }</p>
				<p><c:out value="${ commentaire.contenu }" /></p>
	
	
				<a href="CommentaireUpdate?id=${ commentaire.idCommentaire }" class="linkText">Modifier</a> <br>
			</c:forEach>			
				
		</form>
		
		<jsp:include page="Footer.jsp"></jsp:include>
	
	</div>

</body>
</html>