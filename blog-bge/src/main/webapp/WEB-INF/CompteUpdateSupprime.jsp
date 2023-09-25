<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Suppression de mon compte</title>
</head>
<body>
<div class="container">

	<jsp:include page="Header.jsp"></jsp:include>
	
	<section class="innerContainer">
		<h2>Demande de suppression de compte</h2>

		<form method="POST" action="CompteUpdateSupprime" class="innercontainer">
			
			<input type="hidden" name="id" value="${ compteConnecte.idCompte }">
		
			<fieldset class="formItems innerContainer">
			
				<legend>Suppression de compte avec suppression totale des données</legend>
										
				<label for="trueSupprimeDonnee">Oui</label>
				<input type="radio" id="trueSupprimeDonnee" name="suppressionDonnee" value="true"> 
						
				<label for="falseSupprimeDonnee">Non</label>
				<input type="radio" id="falseSupprimeDonnee" name="suppressionDonnee" value="true"> 
				
				<input type="submit" value="Envoyer" class="formItems innerContainer"/> <br />	
			</fieldset>	
	
			
	
		</form>
	</section>	
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</div>		
</body>
</html>