package fr.bge.blog_bge.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.bge.blog_bge.dao.CommentaireDao;
import fr.bge.blog_bge.dao.Dao;
import fr.bge.blog_bge.dao.jpa.CommentaireDaoJpa;
import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.model.Commentaire;
import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.service.ArticleService;
import fr.bge.blog_bge.service.CommentaireService;
import fr.bge.blog_bge.service.CompteService;


public class CommentaireServiceImpl extends AbstractServiceImpl<Commentaire> implements CommentaireService  {

	private final static CommentaireService INSTANCE = new CommentaireServiceImpl();
	private CommentaireDao dao = CommentaireDaoJpa.getInstance();
	private ArticleService articleService = ArticleServiceImpl.getInstance();
	
	private CommentaireServiceImpl() {
		
	}
	
	public static CommentaireService getInstance() {
		return INSTANCE;
	}
	
	@Override
	public Commentaire create(Compte compteConnecte, Long idArticle, String contenu) {
		Commentaire c = new Commentaire();
		
		Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        
		c.setContenu(contenu);
		c.setDateCreation(currentDate);
		c.setDateModification(currentDate);
		c.setModere(false);
		c.setPublic_(false);
		
		
		c.setCompte(compteConnecte);
		
		Article a = this.articleService.get(idArticle);
		c.setArticle(a);
		
		return c;
	}

	@Override
	public Dao<Commentaire> getDao() {
		return dao;
	}

	@Override
	public List<Commentaire> findCommentaireFetchCompte(long idArticle) {
		return this.dao.findCommentaireFetchCompte(idArticle);
	}

}
