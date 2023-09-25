package fr.bge.blog_bge.service;

import java.util.List;

import fr.bge.blog_bge.dao.Dao;
import fr.bge.blog_bge.model.Commentaire;
import fr.bge.blog_bge.model.Compte;

public interface CommentaireService extends Dao<Commentaire> {


	List<Commentaire> findCommentaireFetchCompte(long id);

	Commentaire create(Compte compteConnecte, Long idArticle, String contenu);

}
