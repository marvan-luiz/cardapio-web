package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Cliente;

@WebServlet(urlPatterns = "/servletCliente")
public class ServletCliente extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Cliente cliente = new Cliente();
		cliente.setNome(req.getParameter("nome"));
		cliente.setTelefone(req.getParameter("telefone"));
		cliente.setCidade(req.getParameter("cidade"));
		cliente.setEndereco(req.getParameter("endereco"));
		
		System.out.println(cliente.toString());
		
		HttpSession sessao = req.getSession();
		sessao.setAttribute("objCliente", cliente);
		
		resp.sendRedirect("concluir-pedido.jsp");
	}
	
}