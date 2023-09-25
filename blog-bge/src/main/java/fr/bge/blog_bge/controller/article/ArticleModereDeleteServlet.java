package fr.bge.blog_bge.controller.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.service.ArticleService;
import fr.bge.blog_bge.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class ArticleModereDeleteServlet
 */
@WebServlet("/ArticleModereDelete")
public class ArticleModereDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService service = ArticleServiceImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleModereDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long idArticle = Long.parseLong(request.getParameter("id"));
		
        Article article = this.service.remove(idArticle);

        response.sendRedirect(request.getContextPath()+"");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
