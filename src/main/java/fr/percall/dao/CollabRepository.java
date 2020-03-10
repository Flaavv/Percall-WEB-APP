package fr.percall.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.percall.collab.Collaborators;

public interface CollabRepository extends JpaRepository<Collaborators, Integer> {
	
	@Query("select c from Collaborators c where c.name like :x group by name")
	public Page<Collaborators> chercher(@Param("x")String mc, Pageable pageable);
	
	
	
	
	
	
	

}
