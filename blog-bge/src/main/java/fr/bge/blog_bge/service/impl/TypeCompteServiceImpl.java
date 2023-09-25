package fr.bge.blog_bge.service.impl;

import fr.bge.blog_bge.dao.Dao;
import fr.bge.blog_bge.dao.TypeCompteDao;
import fr.bge.blog_bge.dao.jpa.TypeCompteDaoJpa;
import fr.bge.blog_bge.model.TypeCompte;
import fr.bge.blog_bge.service.TypeCompteService;

public class TypeCompteServiceImpl extends AbstractServiceImpl<TypeCompte> implements TypeCompteService {

	private final static TypeCompteService INSTANCE = new TypeCompteServiceImpl();
	
	private TypeCompteDao dao = TypeCompteDaoJpa.getInstance();
	
	private TypeCompteServiceImpl() {
		//
	}
	
	public static TypeCompteService getInstance() {
		return INSTANCE;
	}

	@Override
	public TypeCompte create(String typeCompte) {
		TypeCompte tc = new TypeCompte();
		tc.setLabel(typeCompte);
		return tc;
	}

	@Override
	public Dao<TypeCompte> getDao() {

		return dao;
	}

}
