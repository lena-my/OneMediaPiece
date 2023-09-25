package fr.bge.blog_bge.controller.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.ArticleService;
import fr.bge.blog_bge.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class ArticleCreateServlet
 */
@WebServlet(description = "création d'un nouveau article", urlPatterns = { "/ArticleCreate"})
public class ArticleCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService service = ArticleServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/ArticleCreate.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Compte compteConnecte = (Compte) session.getAttribute("compteConnecte");
		String titre = request.getParameter("title");
		String contenu = request.getParameter("contenu");
		Article article = service.create(compteConnecte, titre, contenu);
		
		if (compteConnecte.getTypeCompte().getIdTypeCompte() == 2 || compteConnecte.getTypeCompte().getIdTypeCompte() == 3 ) {
			article.setModere(true);
		}
		
		article = this.service.save(article);
		doGet(request, response);
	}
}
