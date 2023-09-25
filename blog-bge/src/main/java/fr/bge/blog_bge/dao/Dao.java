package fr.bge.blog_bge.dao;

import java.util.List;

public interface Dao<T> {
	
	List<T> findAll();
	
	public List<T> selectCQ();
	
	T save(T t);
	
	T get(long id);
	
	T remove(long id);
	
	public void update (T t);

}
