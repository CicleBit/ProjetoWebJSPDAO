<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Cidades</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class = "container">
		<h1>Lista de Cidades</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
		<a class='btn btn-primary' href="http://localhost:8080/ProjetoWebJSPDAO/views/Cidade-Form.jsp">Adicionar Cidade</a>
		<a class='btn btn-primary' href = "${pageContext.request.contextPath}/CidadeController?action=LIST">Carregar Lista</a>
 		</p>
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>ID</th>
				<th>Cidade</th>
				<th>Estado</th>
			</tr>
			
			<c:forEach items="${list}" var="cidade">
			
				<tr>
					<td>${cidade.id}</td>
					<td>${cidade.cidade}</td>
					<td>${cidade.estado}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/CidadeController?action=EDIT&id=${cidade.id}">Edit</a>
						
						<!--<a href="http://localhost:8080/ProjetoWebJSPDAO/views/Cidade-Edit.jsp">Edit</a>--> 
						| 
						<a href = "${pageContext.request.contextPath}/CidadeController?action=DELETE&id=${cidade.id}">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>