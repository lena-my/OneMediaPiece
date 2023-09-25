package fr.bge.blog_bge.service.impl;

import java.util.Calendar;
import java.util.Date;



import fr.bge.blog_bge.dao.ArticleDao;
import fr.bge.blog_bge.dao.Dao;
import fr.bge.blog_bge.dao.jpa.ArticleDaoJpa;
import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.ArticleService;

public class ArticleServiceImpl extends AbstractServiceImpl<Article> implements ArticleService {

	private final static ArticleService INSTANCE= new ArticleServiceImpl();
	private ArticleDao dao = ArticleDaoJpa.getInstance();

	private ArticleServiceImpl() {
	}

	public static ArticleService getInstance() {
		return INSTANCE;
	}

	@Override
	public Article create(Compte compteConnecte, String titre, String contenu) {
		Article a = new Article();		
		Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
		
		a.setTitre(titre);
		a.setContenu(contenu);
		a.setDateCreation(currentDate);
		a.setDateModification(currentDate);
		a.setCompte(compteConnecte);
		a.setModere(false);
		a.setPublic_(false);
		return a;
	}

	@Override
	public Dao<Article> getDao() {
		return dao;
	}
}
