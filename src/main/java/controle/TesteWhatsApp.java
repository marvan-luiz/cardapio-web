package controle;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/testeWhatsApp")
public class TesteWhatsApp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fone = "5561994324992";
		String msg = "Olá linha 01\n" + "linha 02\n" + "*Alinha* 03";
		msg = URLEncoder.encode(msg, StandardCharsets.UTF_8.toString());
		resp.sendRedirect("https://api.whatsapp.com/send?phone="+fone+"&text="+msg);
	}
}