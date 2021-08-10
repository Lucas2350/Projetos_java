package br.com.hospital.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hospital.bean.Leitos;
import br.com.hospital.bean.Pacientes;
import br.com.hospital.dao.LeitosDAO;
import br.com.hospital.dao.PacientesDAO;

/**
 * Servlet implementation class ServletLeitosListar
 */
@WebServlet("/listar_leitos.leitos")
public class ServletLeitosListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLeitosListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		   ArrayList jspListaLeitos = new ArrayList<Leitos>();//esta sera mandada para lista da jsp
		   List<Leitos> bdListaLeito = new ArrayList<Leitos>();//lista do banco de dados;
		  
		   try {
			   
			   LeitosDAO leitosDAO = new LeitosDAO();
			   bdListaLeito = leitosDAO.listar();
			   
			   for(int i = 0; i < bdListaLeito.size(); i++) {
			   Leitos leitos = new Leitos();
			   leitos = bdListaLeito.get(i);
			   
			   Map leitoMap = new HashMap();
			   
			   leitoMap.put("numeroLeitos", leitos.getNumeroLeitos());
			   leitoMap.put("local", leitos.getLocal());
				
			   jspListaLeitos.add(leitoMap);
			   
			   }
		   }catch (Exception e) {
				e.printStackTrace();
			}
		   
		   request.setAttribute("jspLeitos", jspListaLeitos);
			RequestDispatcher rd =  request.getRequestDispatcher("listar_leitos.jsp");
			rd.forward(request, response);
	}
}
