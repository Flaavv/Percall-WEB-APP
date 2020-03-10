package fr.percall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.percall.skills.Frameworks;


public interface FrameworksRepository extends JpaRepository<Frameworks, Integer>{
		 
	@Query(value = "SELECT * FROM frameworks GROUP BY name", nativeQuery = true)
	List<Frameworks> findAll();
}
