<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<header>

	<h1 class="title">
		<a href="${pageContext.request.contextPath}">One Media Piece</a>
	</h1>

	<nav>
		<a href="${pageContext.request.contextPath}" class="navArticles navLink">articles</a>
		<ul class="navMenu">
			<c:if test="${not empty sessionScope.compteConnecte}">
				<li class="navItem"><a class="navLink" href="Deconnexion">se déconnecter</a></li>
			</c:if>
			
			<c:if test="${empty sessionScope.compteConnecte}">
				<li class="navItem"><a class="navLink" href="SeConnecter">login</a></li>
			</c:if>
			
			
			<c:if test="${not empty sessionScope.compteConnecte}">
				<li class="navItem"><a class="navLink inscrire" href="SpaceConnecte">${ compteConnecte.pseudonime }</a></li>
			</c:if>
			
			<c:if test="${empty sessionScope.compteConnecte}">
				<li class="navItem"><a class="navLink inscrire" href="CompteCreate">s'inscrire</a></li>
			</c:if>
			
		</ul>
	</nav>

</header>
