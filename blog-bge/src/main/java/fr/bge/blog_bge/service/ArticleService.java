package fr.bge.blog_bge.service;

import fr.bge.blog_bge.dao.ArticleDao;
import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.model.Compte;

public interface ArticleService extends ArticleDao {

	public Article create(Compte compteConnecte, String titre, String contenu);

}
