package fr.bge.blog_bge.controller.compte;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.CompteService;
import fr.bge.blog_bge.service.impl.CompteServiceImpl;

/**
 * Servlet implementation class CompteUpdateSignaleServlet
 */
@WebServlet("/CompteUpdateSignale")
public class CompteUpdateSignaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompteService service = CompteServiceImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteUpdateSignaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Compte> list = this.service.findAll();
		
		request.setAttribute("comptes", list);
		this.getServletContext().getRequestDispatcher("/WEB-INF/CompteUpdateSignale.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		boolean banni = Boolean.parseBoolean(request.getParameter("banni"));
		
		Compte compte = this.service.get(id);
		compte.setBani(banni);
	
		this.service.update(compte);
		doGet(request, response);
	}

}
