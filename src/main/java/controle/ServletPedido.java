package controle;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;
import dao.ListaProdutoDao;
import dao.PedidoDao;
import modelo.Cliente;
import modelo.ListaProduto;
import modelo.Pedido;

@WebServlet(urlPatterns = "/servletPedido")
public class ServletPedido extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1 - gravar o cliente no banco de dados

		ClienteDao daoCliente = new ClienteDao();
		HttpSession sessao = req.getSession();
		Cliente cliente = (Cliente) sessao.getAttribute("objCliente");
		daoCliente.incluir(cliente);

		Pedido pedido = (Pedido) sessao.getAttribute("objPedido");
		pedido.setCliente(cliente);
		pedido.setDataPedido(LocalDate.now());

		PedidoDao daoPedido = new PedidoDao();
		daoPedido.incluir(pedido);

		ListaProduto[] lsProduto = (ListaProduto[]) sessao.getAttribute("lsProduto");
		ListaProdutoDao daoListaP = new ListaProdutoDao();
		String lsItem = "";
		for (ListaProduto item : lsProduto) {
			item.setIdPedido(pedido.getId());
			daoListaP.incluir(item);
			lsItem += "\n"+item.getProduto().getNome()+"/"+item.getQuantidade()+"/"+item.getTotal();
		}
		String fone = "5561994324992";
		String msg = "Olá, me chamo "+cliente.getNome()+
				"\nFiz o pedido de N° "+pedido.getId()+
				"\n*Produto/Qt/Total*"+
				lsItem+
				"\n*Valor Final "+pedido.getTotal()+"*"+
				"\nPara ser entregue em "+cliente.getEndereco()+" - "+cliente.getCidade();
		msg = URLEncoder.encode(msg,StandardCharsets.UTF_8.toString());
		resp.sendRedirect("https://api.whatsapp.com/send?phone="+fone+"&text="+msg);
	}

}