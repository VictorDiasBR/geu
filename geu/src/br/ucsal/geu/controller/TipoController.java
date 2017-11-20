package br.ucsal.geu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.geu.dao.BlocoDAO;
import br.ucsal.geu.dao.TipoDAO;
import br.ucsal.geu.model.Bloco;
import br.ucsal.geu.model.Tipo;

@WebServlet("/tipo")
public class TipoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TipoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			request.getRequestDispatcher("tipoform.jsp").forward(request, response);
		} else {
			TipoDAO dao = new TipoDAO();
			request.setAttribute("lista2", dao.listar());
			request.getRequestDispatcher("tipolist.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nome = request.getParameter("nome");
		String descricao= request.getParameter("descricao");
		Tipo tipo = new Tipo();
		tipo.setNome(nome);
		tipo.setDescricao(descricao);
		TipoDAO dao = new TipoDAO();
		dao.inserir(tipo);

		request.setAttribute("lista2", dao.listar());
		request.getRequestDispatcher("tipolist.jsp").forward(request, response);
		
	}

}