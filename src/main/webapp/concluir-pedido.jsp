<%@page import="modelo.Pedido"%>
<%@page import="modelo.ListaProduto"%>
<%@page import="modelo.Cliente"%>
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
		<%
			HttpSession sessao = request.getSession();
			Cliente cliente = (Cliente) sessao.getAttribute("objCliente");
			out.print("Cliente: " + cliente.getNome());
			ListaProduto[] lsProduto = (ListaProduto[]) sessao.getAttribute("lsProduto");
		%>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Produto</th>
					<th>QT</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				<%
					Pedido pedido = new Pedido();
					for (ListaProduto item : lsProduto) {
						out.println("<tr>");
						out.println("<td>" + item.getProduto().getNome() + "</td>");
						out.println("<td>" + item.getQuantidade() + "</td>");
						out.println("<td>" + item.getTotal() + "</td>");
						out.println("</tr>");
						pedido.setTotal(pedido.getTotal() + item.getTotal());
					}
					out.println("<tr>");
					out.println("<td>Total do pedido</td>");
					out.println("<td></td>");
					out.println("<td>" + pedido.getTotal() + "</td>");
					out.println("</tr>");
					sessao.setAttribute("objPedido", pedido);
				%>
			</tbody>
		</table>
		Dados da Entrega:<br>
		<%
			out.print(cliente.getEndereco() + " - " + cliente.getCidade());
		%>

	</div>
	<form action="servletPedido" method="post">
		<button id="bt-concluir-pedido" name="submit" type="submit"
			class="btn btn-primary confirmar">Concluir Pedido</button>
	</form>
</body>
</html>