package fr.bge.blog_bge.controller.article;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.service.ArticleService;
import fr.bge.blog_bge.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class ArticleReadServlet
 */
@WebServlet("/ArticleRead")
public class ArticleReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleService service = ArticleServiceImpl.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> list = this.service.selectCQ();
		request.setAttribute("articles", list);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ArticleRead.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
