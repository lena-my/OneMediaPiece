<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Inscription</title>
</head>
<body>
	<div class="container">
	


		<jsp:include page="Header.jsp"></jsp:include>

		<h2>Inscription</h2>	
		
		<form method="post" action="/blog-bge/CompteCreate">
			<fieldset class="innerContainer">

				<div class="formItems">
					<label for="pseudo">Pseudonime*</label> <br /> 
					<input type="text" id="pseudo" name="pseudo" /> <br /> 
				</div>

				<div class="formItems">					
					<label for="email">E-mail*</label><br />
					<input type="text" id="email" name="email" /> <br /> 
				</div>	
				
				<div class="formItems">
					<label for="password">Mot de passe*</label><br /> 
					<input type="password" id="password" name="password" /> <br /> 
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