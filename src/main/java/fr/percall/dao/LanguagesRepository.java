package fr.percall.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.percall.collab.Collaborators;
import fr.percall.skills.Languages;

public interface LanguagesRepository extends JpaRepository<Languages, Integer> {
	
	@Query("select l from languages l where l.name like :x")
	public Page<Languages> chercher(@Param("x")String mc, Pageable pageable);
	
	@Query(value = "select * from languages", nativeQuery = true)
	public Page<Languages> showLanguages(Pageable pageable);
	
	@Query(value = "SELECT * FROM languages GROUP BY name", nativeQuery = true)
	List<Languages> findAll();
}