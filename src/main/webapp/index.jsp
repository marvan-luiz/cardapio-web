<%@page import="dao.ProdutoDao"%>
<%@page import="modelo.Produto"%>
<%@page import="java.util.List"%>
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

	<h2 class="bg-dark text-white">Cardápio Web</h2>

	<div class="container">

		<form>
			<%
				ProdutoDao dao = new ProdutoDao();
				List<Produto> ls = dao.buscarTudo();
				for (Produto p : ls) {
			%>
			<div class="produto">
				<div class="form-group row number-input">
					<label for="prd-1" class="col-7 col-form-label"><%=p.getNome()%></label>
					<div class="col-5">
						<div class="input-group">
							<div class="input-group-prepend"
								onclick="this.parentNode.querySelector('input[type=number]').stepDown(); atualizar('prd-<%=p.getId()%>',<%=p.getPreco()%>);">
								<div class="input-group-text">
									<i class="fa fa-chevron-down"></i>
								</div>
							</div>
							<input id="prd-<%=p.getId()%>" name="prd-<%=p.getId()%>"
								type="number" class="form-control" value="0" min="0">
							<div class="input-group-append"
								onclick="this.parentNode.querySelector('input[type=number]').stepUp(); atualizar('prd-<%=p.getId()%>',<%=p.getPreco()%>);">
								<div class="input-group-text">
									<i class="fa fa-chevron-up"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-12 valor">
					R$
					<%=p.getPreco()%></div>
				<hr />
			</div>

			<%
				}
			%>

		</form>
	</div>


	<button id="bt-confirmar" onclick="enviar()" disabled="disabled"
		name="submit" type="submit" class="btn btn-primary confirmar">
		Confirmar R$ <span id="span-confirmar">0.00</span>
	</button>
	<script type="text/javascript">
		
		function enviar(){
			var xmlhttp = new XMLHttpRequest();
			
			xmlhttp.onreadystatechange = function(){
				if(this.readyState == 4 && this.status == 200){
					location.replace(this.responseText);
				}
			}
			
			var url = "enviarListaItem";
			xmlhttp.open("POST",url);
			xmlhttp.setRequestHeader("Content-Type","application/json;charset=UTF-8");
			xmlhttp.send(JSON.stringify(lsItem));
			console.log(xmlhttp);
		}
		</script>

</body>
</html>