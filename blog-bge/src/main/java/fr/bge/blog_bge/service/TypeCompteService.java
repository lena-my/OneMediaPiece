package fr.bge.blog_bge.service;

import fr.bge.blog_bge.dao.TypeCompteDao;
import fr.bge.blog_bge.model.TypeCompte;

public interface TypeCompteService extends TypeCompteDao {

	public TypeCompte create(String typeCompte);
	
}
