package fr.bge.blog_bge.controller.compte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.bge.blog_bge.dao.jpa.CompteDaoJpa;
import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.CompteService;
import fr.bge.blog_bge.service.impl.CompteServiceImpl;

/**
 * Servlet implementation class CompteDeleteServlet
 */
@WebServlet("/CompteDelete")
public class CompteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private CompteService service = CompteServiceImpl.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Compte c = Compte.class.cast(session.getAttribute("compte"));
		request.setAttribute("comptes", new CompteDaoJpa().findAll());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CompteDelete.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] ids = request.getParameterValues("id");
		
		if (ids != null) {
		    
			for (String id : ids) {
		        
				long idCompte = Long.parseLong(id);
		        Compte compte = this.service.remove(idCompte);
		    
			}
		}
		

		doGet(request, response);
	}

}
