package br.com.hospital.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import br.com.hospital.bean.Pacientes;
import br.com.hospital.dao.PacientesDAO;



@WebServlet("/cadastrar_pacientes.pacientes")
public class ServletPacientesCadastrar extends  HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletPacientesCadastrar() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		try {
		
			Pacientes pacientes = new Pacientes();
		
			PacientesDAO pacientesDAO = new PacientesDAO();
		
			

		//sets
		pacientes.setNome(request.getParameter("nome"));
		pacientes.setConvenio(request.getParameter("convenio"));
		
			pacientesDAO.salvar(pacientes); 	


		} catch (Exception e) {
			e.printStackTrace();
		}
		

		request.setAttribute("menssagem", "Cadastrou paciente com sucesso "+request.getParameter("nome")); 
		RequestDispatcher rd = request.getRequestDispatcher("cadastrar_pacientes.jsp"); 
		rd.forward(request, response); 
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
