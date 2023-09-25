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
<title>Commentaires</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<form method="post" action="/blog-bge/CommentaireReadModere" class="innerContainer">
		<p><a href="CommentaireCreate?idArticle=${idArticle}" class="linkText">ajouter un commentaire</a></p>
		<c:forEach items = "${ commentaires }" var="commentaire">	
			<div class="commentaireContainer">
				<c:if test="${ commentaire.modere == true }">
					<p>Id: <c:out value="${ commentaire.idCommentaire }" /></p>
					<p>Id Article: ${idArticle}</p>
					<input type="hidden" name="id" value="${ commentaire.idCommentaire }">
					<p>Pseudonime: "${ commentaire.compte.pseudonime }</p>
					<p><c:out value="${ commentaire.contenu }" /></p>
					<c:if test="${ commentaire.compte.idCompte == sessionScope.compteConnecte.idCompte}">	
						<a href="CommentaireUpdate?id=${ commentaire.idCommentaire }" class="linkText">Modifier</a> <br>
						<a href="CommentaireModereDelete?id=${ commentaire.idCommentaire }" class="linkDelete">Supprimer</a>
					</c:if>
				</c:if>
			</div>
		</c:forEach>			
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>

</body>
</html>