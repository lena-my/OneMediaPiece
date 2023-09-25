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
<title>Nouveau commentaire</title>
</head>
<body>

<div class="container">

	<jsp:include page="Header.jsp"></jsp:include>

	<h3>Nouveau commentaire</h3>

	<form method="post" action="/blog-bge/CommentaireCreate"class="innerContainer">
		<fieldset>
		<input type="hidden" name="idArticle" value="${idArticle}">	
			

			<div class="formItems">
				<label for="contenu">Ajouter un commentaire</label> <br />
				<textarea class="textAreaComment" name="contenu"></textarea><br />
			</div>
			
			<input type="submit" value="Envoyer"/> <br />
		</fieldset>
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>

</div>
</body>
</html>