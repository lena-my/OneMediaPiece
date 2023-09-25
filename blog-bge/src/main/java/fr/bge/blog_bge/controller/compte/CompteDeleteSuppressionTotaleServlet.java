package fr.bge.blog_bge.controller.compte;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.CompteService;
import fr.bge.blog_bge.service.impl.CompteServiceImpl;

/**
 * Servlet implementation class CompteDeleteSuppressionTotaleServlet
 */
@WebServlet("/CompteDeleteSuppressionTotale")
public class CompteDeleteSuppressionTotaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompteService service = CompteServiceImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteDeleteSuppressionTotaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Compte> list = this.service.selectCQ();
		
		request.setAttribute("comptes", list);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CompteDeleteSuppressionTotale.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("id");
		
		if (ids != null) {
		    
			for (String id : ids) {
		        
				long idCompte = Long.parseLong(id);
		        Compte compte = this.service.remove(idCompte);
		    
			}
		}
		

		doGet(request, response);
	}

}
