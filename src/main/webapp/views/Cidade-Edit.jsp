<script type="text/javascript">
	function Voltar() {
		location.href = "/ProjetoWebJSPDAO/views/Cidade-List.jsp";
	}
</script>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualizar Cidade</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">

		<h1>Atualizar Cidade</h1>
		<hr />
		<div class="row">
			<div class="col-md-4">
				<form action="${pageContext.request.contextPath}/CidadeController"
					method="POST">
					<p>
					<div class="form-group">
						<input type="text" class="form-control" name="id"
							placeholder="Id" value="${cidade.id}" readonly/>
					</div>
					<p>
					<div class="form-group">
						<input type="text" class="form-control" name="cidade"
							placeholder="Nome da Cidade" value="${cidade.cidade}" />
					</div>

					<div class="form-group">
						<input type="text" class="form-control" name="estado"
							placeholder="Sigla do Estado" value="${cidade.estado}" />
					</div>

					<button type="submit" class="btn btn-primary">Salvar</button>
				</form>
			</div>
		</div>
		<a
			href="${pageContext.request.contextPath}/CidadeController?action=LIST">Voltar
			para cidades</a>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>