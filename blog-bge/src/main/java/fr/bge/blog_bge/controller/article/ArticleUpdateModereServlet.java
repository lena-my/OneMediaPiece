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
 * Servlet implementation class ArticleUpdateModereServlet
 */
@WebServlet("/ArticleUpdateModere")
public class ArticleUpdateModereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArticleService service = ArticleServiceImpl.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleUpdateModereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> list = this.service.selectCQ();
		request.setAttribute("articles", list);
		this.getServletContext().getRequestDispatcher("/WEB-INF/ArticleUpdateModere.jsp").forward( request, response );
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("id");
		if (ids != null) {
			for (String id : ids) {
				long idArticle = Long.parseLong(id);
		        Article article = this.service.get(idArticle);
		        article.setModere(true);
		        this.service.update(article);
			}
		}
		
		doGet(request, response);
	}

}
