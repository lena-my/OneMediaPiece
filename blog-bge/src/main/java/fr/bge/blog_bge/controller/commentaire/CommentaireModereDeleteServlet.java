package fr.bge.blog_bge.controller.commentaire;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Commentaire;
import fr.bge.blog_bge.service.CommentaireService;
import fr.bge.blog_bge.service.impl.CommentaireServiceImpl;

/**
 * Servlet implementation class CommentaireModereDeleteServlet
 */
@WebServlet("/CommentaireModereDelete")
public class CommentaireModereDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentaireService service = CommentaireServiceImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentaireModereDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idCommentaire = Long.parseLong(request.getParameter("id"));
		Commentaire commentaire = this.service.remove(idCommentaire);
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
