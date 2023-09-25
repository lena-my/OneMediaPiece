package fr.bge.blog_bge.service.impl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import fr.bge.blog_bge.dao.CompteDao;
import fr.bge.blog_bge.dao.Dao;
import fr.bge.blog_bge.dao.jpa.CompteDaoJpa;
import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.model.TypeCompte;
import fr.bge.blog_bge.service.CompteService;
import fr.bge.blog_bge.service.TypeCompteService;
import fr.bge.blog_bge.utils.EntityManagerSingleton;

public class CompteServiceImpl extends AbstractServiceImpl<Compte> implements CompteService {

	private final static CompteService INSTANCE = new CompteServiceImpl();

	private CompteDao dao = CompteDaoJpa.getInstance();

	private TypeCompteService typeCompteService = TypeCompteServiceImpl.getInstance();

	private CompteServiceImpl() {

	}

	public static CompteService getInstance() {
		return INSTANCE;
	}

	@Override
	public Compte create(String pseudo, String email, String password) {
		// TODO Vérification de la syntaxe du mail
		// TODO Vérification de la complexité du mot de passe
		// TODO Vérification de la syntaxe du pseudo
		Compte c = new Compte();
		c.setPseudonime(pseudo);
		c.setEmail(email);
		c.setMotDePasse(password); 
		c.setValide(false);
		// On va récupérer le compte Redacteur par defaut
		TypeCompte tc = this.typeCompteService.get(1L);
		c.setTypeCompte(tc);
		return c;
	}

	@Override
	public Dao<Compte> getDao() {

		return dao;
	}

	@Override
	public Compte findCompte(String email, String motDePasse) {

		return this.dao.findCompte(email, motDePasse);


	}

}
