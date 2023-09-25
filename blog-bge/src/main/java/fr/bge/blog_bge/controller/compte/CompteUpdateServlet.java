package fr.bge.blog_bge.controller.compte;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.model.TypeCompte;
import fr.bge.blog_bge.service.CompteService;
import fr.bge.blog_bge.service.TypeCompteService;
import fr.bge.blog_bge.service.impl.CompteServiceImpl;
import fr.bge.blog_bge.service.impl.TypeCompteServiceImpl;

/**
 * Servlet implementation class CompteUpdateServlet
 */
@WebServlet("/CompteUpdate")
public class CompteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CompteService service = CompteServiceImpl.getInstance();
	private TypeCompteService serviceTypeCompte = TypeCompteServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteUpdateServlet() {
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
		
		Compte compte = this.service.get(Long.parseLong(id));
		
		request.setAttribute("compte",compte);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CompteUpdate.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		boolean banni = Boolean.parseBoolean(request.getParameter("banni"));
		boolean signale = Boolean.parseBoolean(request.getParameter("signale"));
		boolean supprime = Boolean.parseBoolean(request.getParameter("supprime"));
		boolean suppressionDonnee = Boolean.parseBoolean(request.getParameter("suppressionDonnee"));
		boolean valide = Boolean.parseBoolean(request.getParameter("valide"));
		Long idTypeCompte = Long.parseLong(request.getParameter("typeCompte"));
		
		TypeCompte typeCompte =  this.serviceTypeCompte.get(idTypeCompte);
				
		Compte compte = this.service.get(id);
		compte.setBani(banni);
		compte.setSignale(signale);
		compte.setSupprime(supprime);
		compte.setSupressionDonnee(suppressionDonnee);
		compte.setValide(valide);
		compte.setTypeCompte(typeCompte);
		
		this.service.update(compte);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CompteRead.jsp").forward( request, response );
	}

}
