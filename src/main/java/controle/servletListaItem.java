package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.ProdutoDao;
import modelo.ListaProduto;

@WebServlet(urlPatterns = "/enviarListaItem")
public class servletListaItem extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StringBuffer sb = new StringBuffer();
		String linha = null;
		try {
			BufferedReader reader = req.getReader();
			while ((linha = reader.readLine()) != null) {
				sb.append(linha);
			}

		} catch (Exception e) {
		}
		
		String sgListaProduto = 
				sb.toString().replace("null,", "").replace("\"id\"", "\"idProduto\"");

		System.out.println(sgListaProduto);

		HttpSession sessao = req.getSession();
		sessao.setAttribute("lista-item-json", sgListaProduto);
		
		Gson gson = new Gson();
		ListaProduto[] lsProduto;
		lsProduto = gson.fromJson(sgListaProduto, ListaProduto[].class);
		
		ProdutoDao dao = new ProdutoDao();
		for (ListaProduto item : lsProduto) {
			item.setProduto(dao.buscarID(item.getIdProduto()));
			System.out.println(item);
		}
		
		sessao.setAttribute("lsProduto", lsProduto);

		PrintWriter out = resp.getWriter();
		out.print("form-cliente.jsp");

	}
}