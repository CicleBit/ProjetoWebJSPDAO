<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class = "container">
	
		<h1>Adicionar Cidade</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/CidadeController" method="POST">
				
					
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "cidade" placeholder = "Nome da Cidade" value = "${cidade.cidade}"/>
					</div>
				
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "estado" placeholder = "Sigla do Estado" value = "${cidade.estado}"/>
					</div>
				
					<input type = "hidden" name = "id" value = "${cidade.id}"/>
				
					<button type = "submit" class = "btn btn-primary">Salvar</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/CidadeController?action=LIST">Voltar para Cidades</a>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>