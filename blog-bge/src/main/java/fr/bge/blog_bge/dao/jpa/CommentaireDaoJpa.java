package fr.bge.blog_bge.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import fr.bge.blog_bge.dao.CommentaireDao;
import fr.bge.blog_bge.model.Commentaire;
import fr.bge.blog_bge.model.Commentaire_;
import fr.bge.blog_bge.model.Compte;
import fr.bge.blog_bge.utils.EntityManagerSingleton;

public class CommentaireDaoJpa extends AbstractDaoJpa<Commentaire> implements CommentaireDao {

	private final static CommentaireDao INSTANCE = new CommentaireDaoJpa();


	public CommentaireDaoJpa() {

	}

	public static CommentaireDao getInstance() {
		return INSTANCE;
	}


	@Override
	public Class<Commentaire> getModelClass() {
		return Commentaire.class;
	}


	@Override
	public String getTableName() {

		return "Commentaire";
	}


	/**
	 * Récupère la liste des commentaires d'un article en faisant un fetch sur le Compte (auteur du comment)
	 * SELECT com.*, cpt.*
	 *         FROM Commentaire com
	 *         INNER JOIN Compte cpt ON cpt.id = com.fkCompte
	 *         WHERE com.fkArticle = idArticle
	 */
	@Override
	public List<Commentaire> findCommentaireFetchCompte(Long idArticle) {
		
		EntityManager em = EntityManagerSingleton.getInstance().getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Commentaire> query = builder.createQuery(Commentaire.class); // SELECT Commentaire.*, (( + le fetch ))
		Root<Commentaire> root = query.from(Commentaire.class); // FROM Commentaire c
		query.select(root); // SELECT Article.* FROM

		Fetch<Commentaire, Compte> fetchCompte = root.fetch(Commentaire_.compte, JoinType.INNER);
		// INNER JOIN Compte cpt ON = c.compte = cpt.compte
		// SELECT Commentaire.*, Compte.*

		query.where(builder.equal(root.get(Commentaire_.article), idArticle));
		// WHERE cpt.id = idArtlce

		return em.createQuery(query).getResultList();    
	}
}
