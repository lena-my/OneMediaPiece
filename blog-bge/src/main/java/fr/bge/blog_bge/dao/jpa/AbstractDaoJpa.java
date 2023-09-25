package fr.bge.blog_bge.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.bge.blog_bge.dao.Dao;
import fr.bge.blog_bge.utils.EntityManagerSingleton;


public abstract class AbstractDaoJpa<T> implements Dao<T>{
	
	private EntityManager em = EntityManagerSingleton.getInstance().getEntityManager();
	public abstract Class<T> getModelClass();
	public abstract String getTableName();
	
	protected EntityManager getEm() {
		return em;
	}
	
	@Override
	@Deprecated
	public List<T> findAll() {

		List<T> list = em.createQuery("SELECT t FROM " + getTableName() + " t").getResultList();
		return list;
	}
	
	
	public List<T> selectCQ(){
		EntityManager em = EntityManagerSingleton.getInstance().getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getModelClass()); // SELECT Article.*
		Root<T> root = query.from(getModelClass()); // FROM Article artcile
		query.select(root); // A ce moment je donne l'ordre à ma requete de faire le fro : SELECT Article.* FROM 
		return em.createQuery(query).getResultList();
	}
	
	@Override
	public T save(T t) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(t);
			this.em.getTransaction().commit();
			return t;
		} catch (Throwable e) {
			this.em.getTransaction().getRollbackOnly();
			throw e;
		}

	}
	
	@Override
	public T get(long id) {
		return this.em.find(getModelClass(), id); //SELECT * FROM Article WHERE pk = l
	}

	@Override
	public T remove(long id) {
		try {
			this.em.getTransaction().begin();
			T t = this.em.find(getModelClass(), id);
			this.em.remove(t);
			this.em.getTransaction().commit();
			return t;
		} catch (Throwable e) {
			this.em.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void update(T t) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(t);
			this.em.getTransaction().commit();
		} catch (Throwable e) {
			this.em.getTransaction().rollback();
			throw e;
		}
	}
}