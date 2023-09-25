package fr.bge.blog_bge.controller.typeCompte;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.TypeCompte;
import fr.bge.blog_bge.service.TypeCompteService;
import fr.bge.blog_bge.service.impl.TypeCompteServiceImpl;

/**
 * Servlet implementation class TypeCompteServlet
 */
@WebServlet("/TypeCompteRead")
public class TypeCompteReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TypeCompteService service = TypeCompteServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeCompteReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TypeCompte> list = this.service.findAll();
		
		request.setAttribute("typeComptes", list);
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/TypeCompteRead.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
