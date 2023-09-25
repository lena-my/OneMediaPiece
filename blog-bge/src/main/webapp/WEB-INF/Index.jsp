<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;700&family=Poppins:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>One Media Piece</title>
</head>
<body>
	<div class="container">

	<jsp:include page="Header.jsp"></jsp:include>
		
		<section class="articles">
		
		 	
			<jsp:include page="ArticleReadModere.jsp"></jsp:include>
			
		</section>
		
		<jsp:include page="Footer.jsp"></jsp:include>
	
	</div>
</body>
</html>