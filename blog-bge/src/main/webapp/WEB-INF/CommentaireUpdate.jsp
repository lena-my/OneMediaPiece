<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Modification des commentaires</title>
</head>
<body>

<div class="container">

	<jsp:include page="Header.jsp"></jsp:include>

	<h3>Modification de commentaire</h3>

	<form method="post" action="/blog-bge/CommentaireUpdate" class="innerContainer">
		
		<fieldset>
			
			<label>Id ${ commentaire.idCommentaire }</label>
			<input type="text" name="contenu" value="${ commentaire.contenu }"></input>

			<input type="submit" value="Envoyer"/> <br />			
		
		</fieldset>
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</div>

</body>
</html>