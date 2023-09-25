package fr.bge.blog_bge.controller.commentaire;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.dao.jpa.CommentaireDaoJpa;
import fr.bge.blog_bge.model.Commentaire;
import fr.bge.blog_bge.service.CommentaireService;
import fr.bge.blog_bge.service.impl.CommentaireServiceImpl;

/**
 * Servlet implementation class CommentaireUpdateServlet
 */
@WebServlet("/CommentaireUpdate")
public class CommentaireUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private CommentaireService service = CommentaireServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentaireUpdateServlet() {
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

		Commentaire commentaire = this.service.get(Long.parseLong(id));
		request.setAttribute("commentaire", commentaire);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CommentaireUpdate.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String contenu = request.getParameter("contenu");
		
		System.out.println(contenu);
		
		Commentaire commentaire = this.service.get(id);
		commentaire.setDateModification(new Date());
		commentaire.setContenu(contenu);
		this.service.update(commentaire);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CommentaireRead.jsp").forward( request, response );
	}

}
