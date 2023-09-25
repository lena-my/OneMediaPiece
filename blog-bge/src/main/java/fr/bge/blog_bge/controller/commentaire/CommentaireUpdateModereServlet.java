package fr.bge.blog_bge.controller.commentaire;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.model.Commentaire;
import fr.bge.blog_bge.service.CommentaireService;
import fr.bge.blog_bge.service.impl.CommentaireServiceImpl;

/**
 * Servlet implementation class CommentaireUpdateModereServlet
 */
@WebServlet("/CommentaireUpdateModere")
public class CommentaireUpdateModereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CommentaireService service = CommentaireServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentaireUpdateModereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Commentaire> list = this.service.selectCQ();
		
		request.setAttribute("commentaires", list);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CommentaireUpdateModere.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] ids = request.getParameterValues("id");

		if (ids != null) {
		    
			for (String id : ids) {
		        
				long idCommentaire = Long.parseLong(id);
		       	Commentaire commentaire = this.service.get(idCommentaire); 
		       	commentaire.setModere(true);
		       	this.service.update(commentaire);
		       	
			}
		}

		doGet(request, response);
	}

}
