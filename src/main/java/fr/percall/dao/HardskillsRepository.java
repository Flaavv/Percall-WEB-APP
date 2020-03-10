package fr.percall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.percall.skills.Hardskills;


public interface HardskillsRepository extends JpaRepository<Hardskills, Integer> {
	@Query(value = "SELECT * FROM hardskills GROUP BY name", nativeQuery = true)
	List<Hardskills> findAll();
}
