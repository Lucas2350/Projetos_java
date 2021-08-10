package br.com.hospital.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hospital.bean.Pacientes;
import br.com.hospital.dao.PacientesDAO;

/**
 * Servlet implementation class ServletPacienteExcluir
 */
@WebServlet("/excluir_pacientes.pacientes")
public class ServletPacienteExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPacienteExcluir() {
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
	 * @param nome 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pacientes pacientes = new Pacientes();
		
		try {
			
			String nome =request.getParameter("nome");
			
			PacientesDAO pacientesDAO = new PacientesDAO();
			pacientes = pacientesDAO.buscar(nome);
			if((pacientes.getNome() != null)&&(pacientes.getConvenio() != null)) {
				
				request.setAttribute("mensagem0", "--- Excluiu o Paciente(a) ---");
				request.setAttribute("mensagem1", "Nome do Paciente.:"+pacientes.getNome());
				request.setAttribute("mensagem2", "convenio do Paciente.:"+pacientes.getConvenio());
				             PacientesDAO pacientesDAO2 = new PacientesDAO();
							 pacientesDAO2.excluir(nome);
				
			}else {
				request.setAttribute("mensagem0", "---paciente não encontramos no Sistema---");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("excluir_pacientes.jsp"); 
		rd.forward(request, response); 
	}



}
