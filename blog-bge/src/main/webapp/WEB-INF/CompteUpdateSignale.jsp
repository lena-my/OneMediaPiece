<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Liste de comptes signalés</title>
</head>
<body>
<div class="container">

	<jsp:include page="Header.jsp"></jsp:include>
	
	<h3>Liste de comptes signalés</h3>

	<form method="post" action="/blog-bge/CompteUpdateSignale" class="innerContainer">

		<c:forEach items = "${ comptes }" var = "compte">
			
			<c:choose>
				
				<c:when test="${compte.signale==true && compte.bani==false}">
				
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
						
						<div class="formItems">
							<input type="submit" value="Envoyer" /> <br />
						</div>
						
					</fieldset>
					
				</c:when>
				
			</c:choose>
				
		</c:forEach>
				
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>

</div>

</body>
</html>