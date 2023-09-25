<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Nouveau article</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<h3>Nouveau article</h3>
	<form method="post" action="/blog-bge/ArticleCreate">
		<fieldset class="innerContainer">
			<div class="formItems">
				<label for="title">Titre</label> <br />
				<input type="text" id="title" name="title" class="inputTitleArticle"/> <br />
			</div>
			<div class="formItems">
				<label for="contenu">Contenu</label><br />
				<textarea rows="5" cols="50" name="contenu" class="textAreaArticle"> </textarea><br />
			</div>
			<div class="formItems">
				<input type="submit" value="Envoyer"/> <br />
			</div>
		</fieldset>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>