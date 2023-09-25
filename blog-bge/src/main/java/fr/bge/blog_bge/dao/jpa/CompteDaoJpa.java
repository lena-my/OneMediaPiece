package fr.bge.blog_bge.dao.jpa;


import javax.persistence.TypedQuery;

import fr.bge.blog_bge.dao.CompteDao;
import fr.bge.blog_bge.model.Compte;


public class CompteDaoJpa extends AbstractDaoJpa<Compte> implements CompteDao {

	private final static CompteDao INSTANCE = new CompteDaoJpa();
	

	public CompteDaoJpa() {
		
	}
	
	public static CompteDao getInstance() {
		return INSTANCE;
	}

	@Override
	public Class<Compte> getModelClass() {
		
		return Compte.class;
	}

	@Override
	public String getTableName() {

		return "Compte";
	}

	@Override
	public Compte findCompte(String email, String motDePasse) {
		TypedQuery<Compte> query = this.getEm().createQuery(
				"SELECT c FROM Compte c WHERE c.email = :email AND c.motDePasse = :motDePasse", Compte.class);
		query.setParameter("email", email);
		query.setParameter("motDePasse", motDePasse);
		
		Compte c = query.getSingleResult();
		System.out.println(c);
		if (c.getMotDePasse().equals(motDePasse)) {
			return c;
		}
		return null;
		
	}



}
