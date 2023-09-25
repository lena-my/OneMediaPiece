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
 * Servlet implementation class TypeCompteUpdate
 */
@WebServlet("/TypeCompteUpdate")
public class TypeCompteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TypeCompteService service = TypeCompteServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeCompteUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String qs = request.getQueryString();
		String[] keyValuePair = qs.split("=");
		String id = keyValuePair[1];
		TypeCompte typeCompte = this.service.get(Long.parseLong(id));
	
		request.setAttribute("typeCompte", typeCompte);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/TypeCompteUpdate.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Long id = Long.parseLong(request.getParameter("id"));
		String label = request.getParameter("label");
		
		TypeCompte typeCompte = this.service.get(id);
		typeCompte.setLabel(label);
		
		this.service.update(typeCompte);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/TypeCompteRead.jsp").forward( request, response );
	}

}
