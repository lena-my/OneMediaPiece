<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Articles en attente de modération</title>
</head>
<body>
<div class="container">

	<jsp:include page="Header.jsp"></jsp:include>
	
	<section class="articles innerContainer">
			
		<h3>Articles en attente de modération</h3>
		
		<form method="post" action="/blog-bge/ArticleUpdateModere" class="innerContainer">
	
			<table>
				<tr>
					<th></th>
					<th>Auteur</th>
					<th>Id</th>
					<th>Titre</th>
				</tr>

				<c:forEach items = "${ articles }" var = "article">
					<c:if test = "${ article.modere == false}">
						<tr>
							<td><input type="checkbox" name="id" value="${ article.idArticle }"></td>
							<td>${ article.compte.pseudonime }</td>
							<td>${ article.idArticle }</td>
							<td><c:out value="${ article.titre }" /></td>
						</tr>
					</c:if>
				</c:forEach>

			</table>
			
			<input type="submit" value="Mettre en ligne" /> <br />
			
			</form>
					
		</section>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</div>

</body>
</html>