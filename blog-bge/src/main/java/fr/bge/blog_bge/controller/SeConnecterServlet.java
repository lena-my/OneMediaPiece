package fr.bge.blog_bge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.CompteService;
import fr.bge.blog_bge.service.impl.CompteServiceImpl;

/**
 * Servlet implementation class SeConnecterServlet
 */
@WebServlet("/SeConnecter")
public class SeConnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CompteService service = CompteServiceImpl.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeConnecterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/SeConnecter.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");
		
		Compte compte = this.service.findCompte(email, motDePasse);
		//System.out.println(compte.getEmail() + " " + compte.getMotDePasse() + " " + compte.getPseudonime());
		
		
		if (compte == null) {
			System.out.println("Vous n'avez pas de compte");
			doGet(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("compteConnecte", compte);
		
			request.setAttribute("compteConnecte", compte);
			this.getServletContext().getRequestDispatcher("/WEB-INF/SpaceConnecte.jsp").forward( request, response );
		}
		

	}

}
