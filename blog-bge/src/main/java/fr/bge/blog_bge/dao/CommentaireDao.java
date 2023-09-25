package fr.bge.blog_bge.dao;


import java.util.List;

import fr.bge.blog_bge.model.Commentaire;

public interface CommentaireDao extends Dao<Commentaire>{

	public List<Commentaire> findCommentaireFetchCompte(Long idArticle);
}

