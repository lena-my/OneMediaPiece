package fr.bge.blog_bge.controller.article;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.service.ArticleService;
import fr.bge.blog_bge.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class ArticleUpdateServlet
 */
@WebServlet("/ArticleUpdate")
public class ArticleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleService service = ArticleServiceImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleUpdateServlet() {
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
		
		Article article = this.service.get(Long.parseLong(id));
		request.setAttribute("article", article);

		this.getServletContext().getRequestDispatcher("/WEB-INF/ArticleUpdate.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idArticle = Long.parseLong(request.getParameter("id"));
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");

		Article article = this.service.get(idArticle);
		article.setTitre(titre);
		article.setContenu(contenu);
		article.setDateModification(new Date());

		this.service.update(article);	

		this.getServletContext().getRequestDispatcher("/WEB-INF/ArticleRead.jsp").forward( request, response );
	}

}
