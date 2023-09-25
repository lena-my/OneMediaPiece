<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Modifier l'article</title>
</head>
<body>

	<div class="container">

		<jsp:include page="Header.jsp"></jsp:include>

	<h3>Modification de l'article</h3>


		<form method="post" action="/blog-bge/ArticleUpdate">

			<fieldset class="innerContainer">
				<div class="formItems">
					<label for="id">Id: ${ article.idArticle }</label> <br /> 
					<input readonly type="hidden" id="id" name="id" value="${ article.idArticle }" /> <br /> 
				</div>
				
				<div class="formItems">
					<label for="titre">Titre</label> <br /> 
					<input type="text" id="titre" name="titre" value="${ article.titre }" class="inputTitleArticle"/> <br />
				</div>
				
				<div class="formItems">
					<label for="contenu">Contenu</label><br />
					<textarea name="contenu" class="textAreaArticle">${ article.contenu } </textarea> <br />
				</div>
				
				<div class="formItems">
				  <input type="submit" value="Envoyer" /> <br />
				 </div>
				  
			</fieldset>

		</form>
		
		<jsp:include page="Footer.jsp"></jsp:include>
		
	</div>

</body>
</html>