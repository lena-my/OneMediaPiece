package fr.bge.blog_bge.controller.typeCompte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.TypeCompte;
import fr.bge.blog_bge.service.TypeCompteService;
import fr.bge.blog_bge.service.impl.TypeCompteServiceImpl;

/**
 * Servlet implementation class TypeCompteCreateServlet
 */
@WebServlet("/TypeCompteCreate")
public class TypeCompteCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private TypeCompteService service = TypeCompteServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeCompteCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/TypeCompteCreate.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String label = request.getParameter("label");
		
		//Il faudrait controller que tout va bien (non null, non vide, éventuellement de la cybersec)
        // Retourner une erreur HTTP 400 Bad request

		TypeCompte typeCompte = service.create(label);
		typeCompte = this.service.save(typeCompte);
	
		doGet(request, response);
	}

}
