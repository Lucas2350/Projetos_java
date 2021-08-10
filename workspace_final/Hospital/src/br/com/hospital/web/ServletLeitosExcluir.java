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
 * Servlet implementation class ServletLeitosExcluir
 */
@WebServlet("/excluir_leitos.leitos")
public class ServletLeitosExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLeitosExcluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Leitos leitos = new Leitos();
		
		try{ 
			
		int numLeitos = Integer.parseInt(request.getParameter("numeroLeitos"));
			
			LeitosDAO leitosDAO = new LeitosDAO();
			leitos = leitosDAO.buscar(numLeitos);
			if((leitos.getNumeroLeitos() != 0)&&(leitos.getLocal() != null)) {
				request.setAttribute("mensagem0", "--- Excluiu o Leito ---");
				request.setAttribute("mensagem1", "Numero do Leito:"+leitos.getNumeroLeitos());
				request.setAttribute("mensagem2", "Local do Leito:"+leitos.getLocal());
				LeitosDAO leitosDAO2 = new LeitosDAO();
				leitosDAO2.excluir(numLeitos);
			}else {
				request.setAttribute("mensagem0", "---leito não encontramos no Sistema---");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("excluir_leitos.jsp"); 
		rd.forward(request, response); 
	}
}
