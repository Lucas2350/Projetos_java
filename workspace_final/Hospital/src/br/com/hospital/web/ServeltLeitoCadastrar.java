package br.com.hospital.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hospital.bean.Leitos;
import br.com.hospital.dao.LeitosDAO;

/**
 * Servlet implementation class ServeltLeitoCadastrar
 */
@WebServlet("/cadastrar_leitos.leitos")
public class ServeltLeitoCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServeltLeitoCadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Leitos leitos = new Leitos();
			LeitosDAO leitosDAO = new LeitosDAO();
			
			leitos.setNumeroLeitos(Integer.parseInt(request.getParameter("numeroCamas")));
			leitos.setLocal(request.getParameter("localPredio"));
			
			leitosDAO.salvar(leitos);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("menssagem", "Cadastrou Leito "+request.getParameter("numeroCamas")); 
		RequestDispatcher rd = request.getRequestDispatcher("cadastrar_leitos.jsp"); 
		rd.forward(request, response);
	}

}
