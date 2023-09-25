package fr.bge.blog_bge.dao.jpa;

import fr.bge.blog_bge.dao.TypeCompteDao;
import fr.bge.blog_bge.model.TypeCompte;

public class TypeCompteDaoJpa extends AbstractDaoJpa<TypeCompte> implements TypeCompteDao {

	private final static TypeCompteDao INSTANCE = new TypeCompteDaoJpa();

	public TypeCompteDaoJpa() {
		// a priori rien à faire
	}
	
	public static TypeCompteDao getInstance() {
		return INSTANCE;
	}

	@Override
	public Class<TypeCompte> getModelClass() {
		
		return TypeCompte.class;
	}

	@Override
	public String getTableName() {

		return "TypeCompte";
	}
	
	
}
