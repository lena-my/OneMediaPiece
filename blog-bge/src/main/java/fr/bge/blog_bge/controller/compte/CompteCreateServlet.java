package fr.bge.blog_bge.controller.compte;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.CompteService;
import fr.bge.blog_bge.service.impl.CompteServiceImpl;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/CompteCreate")
public class CompteCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CompteService service = CompteServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CompteCreate.jsp").forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(pseudo + " " + email + " " + password);
	
		
		Compte compte = service.create(pseudo, email, password);
		compte = this.service.save(compte);
		
		response.sendRedirect(request.getContextPath()+"");
	}

}
