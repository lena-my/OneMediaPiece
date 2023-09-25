<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Modification de compte</title>
</head>
<body>

<div class="container">

	<jsp:include page="Header.jsp"></jsp:include>
	
	<h3>Modification de compte</h3>

	<form method="post" action="/blog-bge/CompteUpdate" class="innerContainer">
	
		<fieldset class="formItems innerContainer">
		
			<p>Id ${ compte.idCompte }</p>
			<p>${ compte.pseudonime }<p/>
			<p>${ compte.email }<p/>
			 
			<input type="hidden" id="id" name="id" value="${ compte.idCompte }" /> <br />


			<fieldset class="formItems">

				<legend>Bannir compte</legend>
				
					<label for="trueBanni">Oui</label>
					<input type="radio" id="trueBanni" name="banni" value="true"> 
				
					<label for="falseBanni">Non</label>
					<input type="radio" id="falseBanni" name="banni" value="false"><br />
				
			</fieldset>



			<fieldset class="formItems">

				<legend>Signaler compte</legend>
				
				<label for="trueSignaler">Oui</label>
				<input type="radio" id="trueSignaler" name="signale" value="true"> 
			
				<label for="falseSignaler">Non</label>
				<input type="radio" id="falseSignaler" name="signale" value="false"><br />

			</fieldset>



			<fieldset class="formItems">

				<legend>Supprimer compte</legend>

				<label for="trueSupprimer">Oui</label>
				<input type="radio" id="trueSupprimer" name="supprime" value="true">
				 
				<label for="falseSupprimer">Non</label>
				<input type="radio" id="falseSupprimer" name="supprime" value="false"><br />

			</fieldset>

			<fieldset class="formItems">

				<legend>Supprimer complètement les données</legend>

				<label for="trueSupprimerTotal">Oui</label>
				<input type="radio" id="trueSupprimerTotal" name="suppressionDonnee" value="true">
				
				<label for="falseSupprimerTotal">Non</label>
				<input type="radio" id="falseSupprimerTotal" name="suppressionDonnee" value="false"><br />

			</fieldset>

			<fieldset class="formItems">

				<legend>Valider</legend>

				<label for="trueValider">Oui</label>
				<input type="radio" id="trueValider" name="valide" value="true"> 
				
				<label for="falseValider">Non</label>
				<input type="radio" id="falseValider" name="valide" value="false"><br />

			</fieldset>


			<fieldset class="formItems">

				<legend>Changer le type de compte</legend>

				<label for="redacteur">Rédacteur</label>
				<input type="radio" id="redacteur" name="typeCompte" value="1"><br /> 
				
				<label for="moderateur">Modérateur</label>
				<input type="radio" id="moderateur" name="typeCompte" value="2"><br /> 
				
				<label for="administrateur">Administrateur</label>
				<input type="radio"id="administrateur" name="typeCompte" value="3"><br />

			</fieldset>

			<div class="formItems">
				<input type="submit" value="Envoyer" /> <br />
			</div>
			
		</fieldset>
		
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>

</div>
</body>
</html>