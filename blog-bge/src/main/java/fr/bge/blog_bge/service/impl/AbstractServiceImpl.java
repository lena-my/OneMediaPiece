package fr.bge.blog_bge.service.impl;

import java.util.List;

import fr.bge.blog_bge.dao.Dao;
import fr.bge.blog_bge.model.Article;
import fr.bge.blog_bge.model.Commentaire;
import fr.bge.blog_bge.model.Compte;


public abstract class AbstractServiceImpl<T>  {

	public abstract Dao<T> getDao();
	
	public List<T> findAll() {
		return this.getDao().findAll();
	}
	
	public List<T> selectCQ(){
		return this.getDao().selectCQ();
	}

	public T get(long id) {
		return this.getDao().get(id);
	}
	
	
	public T save(T t) {
		return this.getDao().save(t);
	}


	public T remove(long id) {
		return this.getDao().remove(id);
	}


	public void update(T t) {
		this.getDao().update(t);
	}




}
