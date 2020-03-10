package fr.percall.dao;

import java.util.List;

import fr.percall.collab.Collaborators;

public interface EntityRepository<T>  {
	
	public T save(T c);
	List<T> findAll();
	public T findOne(Integer id);
	public T update(T c);
	public void delete(Integer id);
	public T findByName(String mc);
	

}
