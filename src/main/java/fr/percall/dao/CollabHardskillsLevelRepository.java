package fr.percall.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.percall.skills.CollabHardSkillsLevel;

public interface CollabHardskillsLevelRepository extends JpaRepository<CollabHardSkillsLevel, Integer> {
		
	@Query(value = "select distinct h.name from collab_hardskills_level chl, collaborators c, hardskills h, level l "
			+ " where c.id = chl.collaborators_id and h.id = chl.hardskills_id and l.id = chl.level_id and c.name = :name", nativeQuery = true)
	List<CollabHardSkillsLevel> chl(@Param("name")String name);
}

