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

import br.com.hospital.bean.Pacientes;
import br.com.hospital.dao.PacientesDAO;


@WebServlet("/listar_pacientes.pacientes")

public class ServletPacientesListar extends HttpServlet {
	
			private static final long serialVersionUID = 1L;
		       
	
		    public ServletPacientesListar() {
		        super();
		        // TODO Auto-generated constructor stub
		    }

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				
				doPost(request, response);

			}

		
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
			     ArrayList jspListaPacientes = new ArrayList<Pacientes>();//esta sera mandada para lista da jsp
				  List<Pacientes> bdListaPacientes = new ArrayList<Pacientes>();//lista do banco de dados;
				  
				  try {
					 PacientesDAO pacientesDAO = new PacientesDAO();
					bdListaPacientes = pacientesDAO.listar();  
					 
				  
				  for(int i=0; i <bdListaPacientes.size(); i++ )

				  {
				   Pacientes pacientes = new Pacientes();
				    pacientes = bdListaPacientes.get(i);
				  
				    Map pacientesMap =  new HashMap();
				    pacientesMap.put("nome",pacientes.getNome());
				    pacientesMap.put("convenio",pacientes.getConvenio());
			
				  
				   
		          jspListaPacientes.add(pacientesMap);
				   				  

				   }

				  }catch (Exception e) {
					  e.printStackTrace();
				  }
				  
				  request.setAttribute("jspPacientes",jspListaPacientes);
			  RequestDispatcher rd = request.getRequestDispatcher("listar_pacientes.jsp") ;
			  rd.forward(request,response);  
				
			}
	

}
