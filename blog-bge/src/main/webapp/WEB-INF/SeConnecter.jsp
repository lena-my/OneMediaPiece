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
<title>Se connecter</title>
</head>
<body>
	<div class="container">
	
		<jsp:include page="Header.jsp"></jsp:include>
		
		<h3>se connecter</h3>

		<form method="post" action="/blog-bge/SeConnecter">
			<fieldset class="innerContainer">
				
				<div class="formItems">
					<label for="email">e-mail</label> <br /> 
					<input type="text" id="email" name="email" /> <br /> 
					
				
				</div>
				
				<div class="formItems">
					<label for="motDePasse">mot de passe</label><br /> 
					<input type="password" id="motDePasse" name="motDePasse" /> <br /> 
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