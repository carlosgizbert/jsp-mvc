package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		
		
		Usuario usuario = Login.USUARIOS_LOGADOS.get(cookie.getValue());
		
		PrintWriter writer = resp.getWriter();
		
		if (cookie == null) {
			writer.println("<html><body>Usuário não estava logado!</body></html>");
		} else {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			writer.println("<html><body>Usuário deslogado com sucesso!</body></html>");
		}
	}
}
