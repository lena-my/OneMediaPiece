<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Commentaires en modération</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<section class="innerContainer commentairesUpdateModereSection">
		<h3>Commentaires en attente de modération</h3>
		<p>Cochez les cases des commentaires à publier:</p>
		
		 <form method="post" action="/blog-bge/CommentaireUpdateModere">
			<table>
				<tr>
					<th>Valider</th>
					<th>Id</th>
					<th>Auteur</th>
					<th>Article</th>
					<th>Commentaire</th>

				</tr>
				<c:forEach items = "${ commentaires }" var = "commentaire">	
					<c:if test = "${ commentaire.modere == false}">
						<tr>
							<td><input type="checkbox" name="id" value="${ commentaire.idCommentaire }"></td>
							<td>${ commentaire.idCommentaire }</td>
							<td>${ commentaire.compte.pseudonime }</td>
							<td>${ commentaire.article.titre }</td>
							<td>${ commentaire.contenu }</td>
						</tr>
					</c:if>
				</c:forEach>		
			</table>
			<div class="formItems">
				<input type="submit" value="Envoyer" /> <br />
			</div>
		</form>
	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>