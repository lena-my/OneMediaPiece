package fr.bge.blog_bge.dao;

import fr.bge.blog_bge.model.Compte;

public interface CompteDao extends Dao<Compte> {

	Compte findCompte(String email, String motDePasse);

}
