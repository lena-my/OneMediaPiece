<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Liste des articles</title>
</head>
<body>

<div class="container">
	
	<jsp:include page="Header.jsp"></jsp:include>

		<section class="articles innerContainer flexContainer">
			
			<h2>liste des articles</h2>
		
			<form method="post" action="/blog-bge/ArticleRead">
		
				<article>
					<c:forEach items="${articles}" var="article">
	
					
						<input type="hidden" name="idArticle" value="${ article.idArticle }">
						
						<h3><c:out value="${ article.titre }" /></h3>
						
						<div class="aboutArticle">
							<p>Id: <c:out value="${ article.idArticle }"/></p>
							<p>Auteur: <c:out value="${ article.compte.pseudonime }"/></p>
							<p>Date de création: <c:out value="${ article.dateCreation }"/></p>
							
							<p>Dernière modification: ${ article.dateModification }</p>
						</div>
						
						<p class="contenuArticle">${ article.contenu }</p>
						
						<a href="CommentaireRead?id=${ article.idArticle }" class="linkText">afficher les commentaires</a><br>
						
						<!-- link "modifier" visible only to the creator of the article -->
						<c:if test="${ article.compte.idCompte == sessionScope.compteConnecte.idCompte}">
							<a href="ArticleUpdate?id=${ article.idArticle }" class="linkText">modifier</a>
						</c:if>
						
						<!--<c:if test="${ (article.compte.idCompte == sessionScope.compteConnecte.idCompte) && (article.compte.idCompte==2 || article.compte.idCompte==3)}">
							<a href="">signaler le compte</a>
						</c:if>-->
						
					</c:forEach>
					
				</article>	
				
			</form>
			
		</section>
		
		<jsp:include page="Footer.jsp"></jsp:include>
		
</div>

</body>
</html>