package fr.bge.blog_bge.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.model.TypeCompte;
import fr.bge.blog_bge.service.ArticleService;
import fr.bge.blog_bge.service.TypeCompteService;
import fr.bge.blog_bge.service.impl.ArticleServiceImpl;
import fr.bge.blog_bge.service.impl.TypeCompteServiceImpl;
import fr.bge.blog_bge.utils.EntityManagerSingleton;


/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(description = "La servlet qui va servor pour la racine du site", urlPatterns = { "" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private TypeCompteService service = TypeCompteServiceImpl.getInstance();
	
	private ArticleService service = ArticleServiceImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.getWriter().append("Served at: ").append(request.getContextPath()).append('\n');
		for (TypeCompte tc : this.service.findAll()) {
			response.getWriter().append(tc.getIdTypeCompte().toString()).append(" - ").append(tc.getLabel()).append('\n');
		}*/
		
		
		List<Article> list = this.service.selectCQ();
		request.setAttribute("articles", list);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Index.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
