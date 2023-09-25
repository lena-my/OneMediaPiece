package fr.bge.blog_bge.controller.typeCompte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.dao.jpa.TypeCompteDaoJpa;
import fr.bge.blog_bge.model.TypeCompte;
import fr.bge.blog_bge.service.TypeCompteService;
import fr.bge.blog_bge.service.impl.TypeCompteServiceImpl;

/**
 * Servlet implementation class TypeCompteRemoveServlet
 */
@WebServlet("/TypeCompteDelete")
public class TypeCompteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TypeCompteService service = TypeCompteServiceImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeCompteDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("typeComptes", new TypeCompteDaoJpa().findAll());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/TypeCompteDelete.jsp").forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] ids = request.getParameterValues("id");
		
		if ( ids != null ) {
			
			for ( String id : ids ) {
				
				long idTypeCompte = Long.parseLong(id);
				TypeCompte typeCompte = this.service.remove(idTypeCompte);
				
			}
		}
		
		/*long id = Long.parseLong(request.getParameter("id"));
		
		TypeCompte typeCompte = this.service.remove(id);
		typeCompte = this.service.remove(id);*/
		
		
		doGet(request, response);
	}

}
