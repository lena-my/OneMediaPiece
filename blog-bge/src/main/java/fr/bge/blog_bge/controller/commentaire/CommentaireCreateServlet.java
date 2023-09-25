package fr.bge.blog_bge.controller.commentaire;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.bge.blog_bge.model.Commentaire;
import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.CommentaireService;
import fr.bge.blog_bge.service.impl.CommentaireServiceImpl;

/**
 * Servlet implementation class CommentaireCreateServlet
 */
@WebServlet("/CommentaireCreate")
public class CommentaireCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CommentaireService service = CommentaireServiceImpl.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentaireCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long idArticle = Long.parseLong(request.getParameter("idArticle"));
		
		request.setAttribute("idArticle", idArticle);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CommentaireCreate.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Compte compteConnecte = (Compte) session.getAttribute("compteConnecte");
		
		String contenu = request.getParameter("contenu");
		
		
		Long idArticle = Long.parseLong(request.getParameter("idArticle"));
		
		Commentaire commentaire = service.create(compteConnecte, idArticle, contenu);
		
		if (compteConnecte.getTypeCompte().getIdTypeCompte() == 2 || compteConnecte.getTypeCompte().getIdTypeCompte() == 3 ) {
			commentaire.setModere(true);
		}
		
		commentaire = this.service.save(commentaire);
		
		response.sendRedirect(request.getContextPath()+"");

	}

}
