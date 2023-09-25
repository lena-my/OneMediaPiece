package fr.bge.blog_bge.service;

import fr.bge.blog_bge.dao.CompteDao;
import fr.bge.blog_bge.model.Compte;

public interface CompteService extends CompteDao {

	public Compte create(String pseudo, String email, String password);

	public Compte findCompte(String email, String motDePasse);
	
}
