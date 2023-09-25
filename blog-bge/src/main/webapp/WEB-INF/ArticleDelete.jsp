<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suppression de l'article</title>
</head>
<body>

	<form method="post" action="/blog-bge/ArticleDelete">

		<table>
			<tr>
				<th></th>
				<th>Id</th>
				<th>Titre</th>
			</tr>

			<c:forEach items="${articles}" var="article">
				<tr>
					<td><input type="checkbox" name="id"
						value="${ article.idArticle }"></td>
					<td><c:out value="${article.idArticle}" /></td>
					<td><c:out value="${article.titre}" /></td>
				</tr>
			</c:forEach>

		</table>
		
		 <input type="submit" value="Ok" /> <br />

	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>