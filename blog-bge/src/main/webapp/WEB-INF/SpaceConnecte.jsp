<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Connecte</title>
</head>
<body>
	<div class="container">
	
		<jsp:include page="Header.jsp"></jsp:include>
		
		<h2>Bonjour ${ compteConnecte.pseudonime }</h2>
		
		
		<ul class="innerContainer listUser">
			<li><a href="ArticleCreate">Créer un article</a></li>
	        
	        <c:choose>
		  		<c:when test="${compteConnecte.typeCompte.idTypeCompte == 2 || compteConnecte.typeCompte.idTypeCompte == 3}">
		  			
		        	<li><a href="ArticleUpdateModere">Articles en attente de modération</a></li>
		            <li><a href="CommentaireUpdateModere">Commentaires en attente de modération</a></li>
		           	<li><a href="ArticleRead">Liste des articles</a></li>
		           	<li><a href="CompteUpdate">Signaler un compte</a></li>
		  		
		  		</c:when>
			</c:choose>
			
			<c:if test="${ compteConnecte.typeCompte.idTypeCompte == 3 }">
				
				<li><a href="CompteRead">Lister tous les comptes</a></li>
				<li><a href="CompteUpdateValide">Comptes en attente de validation</a></li>
				<li><a href="CompteUpdateSignale">Comptes signalés</a></li>
				<li><a href="CompteDeleteSuppressionTotale">Demandes de suppression totale des donnéees</a>
				
			</c:if>
	        
	        <li><a href="CompteUpdateSupprime">Suppression de mon compte</a></li>
		</ul>
		
		<jsp:include page="Footer.jsp"></jsp:include>
		
	</div>
</body>
</html>