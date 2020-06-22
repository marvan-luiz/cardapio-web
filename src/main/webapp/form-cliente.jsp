<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cardápio Web</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/estilo.css">
<script type="text/javascript" src="js/funcoes.js"></script>
</head>
<body>
	<form method="post" action="servletCliente" >
		<h2 class="bg-dark text-white">Cardápio Web</h2>
		<div class="container">

			<div class="form-group row">

				<div class="col-12">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-address-card"></i>
							</div>
						</div>
						<input id="nome" name="nome" placeholder="Nome Completo"
							type="text" class="form-control">
					</div>
				</div>
			</div>
			<div class="form-group row">

				<div class="col-12">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-whatsapp"></i>
							</div>
						</div>
						<input id="telefone" name="telefone" placeholder="(DD)9.9999-9999"
							type="text" class="form-control">
					</div>
				</div>
			</div>
			<div class="form-group row">

				<div class="col-12">
					<select id="cidade" name="cidade" class="custom-select">
						<option value="">Cidade</option>
						<option value="Águas Claras">Águas Claras</option>
						<option value="Asa Norte">Asa Norte</option>
						<option value="Asa Sul">Asa Sul</option>
						<option value="Cruzeiro">Cruzeiro</option>
						<option value="Gama">Gama</option>
						<option value="Guará">Guará</option>
						<option value="Jardim Botânico">Jardim Botânico</option>
						<option value="Lago norte">Lago norte</option>
						<option value="Lago sul">Lago sul</option>
						<option value="Noroeste">Noroeste</option>
						<option value="Octogononal">Octogononal</option>
						<option value="Park Sul">Park Sul</option>
						<option value="Sudoeste">Sudoeste</option>
					</select>
				</div>
			</div>
			<div class="form-group row">

				<div class="col-12">
					<input id="endereco" name="endereco" placeholder="Endereço"
						type="text" class="form-control">
				</div>
			</div>

		</div>
		<button id="bt-continuar" onclick="" type="submit"
			class="btn btn-primary confirmar">Continuar</button>
	</form>
</body>
</html>