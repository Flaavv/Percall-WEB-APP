package fr.percall.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.percall.collab.Collaborators;
import fr.percall.skills.CollabLanguagesLevel;
import fr.percall.skills.Languages;
import fr.percall.skills.Level;

public interface CollabLangLevelRepository extends JpaRepository<CollabLanguagesLevel, Integer>{
	
	@Query("select c from CollabLanguagesLevel c where c.collaborators.name like :x")
	 public Page<CollabLanguagesLevel> chercher(@Param("x")String mc, Pageable pageable); 
	
	@Query(value = "select * from collaborators group by name", nativeQuery = true)
	Page<CollabLangLevelRepository> showMeAll(Pageable page);
	
	@Query(value = "select * from collaborators c, collab_languages_level cll, languages l, level lv" +
			 "		where c.id = cll.collaborators_id and l.id = cll.languages_id and lv.id = cll.level_id and c.name = :name", nativeQuery = true)
	Page<CollabLanguagesLevel> cll(@Param("name")String name, Pageable page);
	
	
	
	/** @Query(value = "select collaborators.name as cn, languages.name from collaborators inner join languages on collaborators.id = languages.id", nativeQuery = true)
	public Page<Collaborators> showAll(Pageable page); */
	
	@Query("select c from CollabLanguagesLevel c where c.languages.name like :x and c.level.level like :y")
	public Page<CollabLanguagesLevel> lookFor(@Param("x")String mc, @Param("y")int x, Pageable pageable);
	
	@Query(value = "select * from collab_languages_level inner join collaborators on collaborators.id= collab_languages_level.collaborators_id\r\n" + 
			"			inner join languages on languages.id = collab_languages_level.languages_id\r\n" + 
			"			inner join level on level.id = collab_languages_level.level_id\r\n" + 
			"			where level.level = :level.level and languages.name = :languages.name", nativeQuery = true)
	public Page<CollabLanguagesLevel> findByLangLevel( @Param("languages.name")String languagesx, @Param("level.level")int levelx, Pageable page);
	
	
	@Query(value = "select * from collab_languages_level\r\n" + 
			"    inner join collaborators on collaborators.id= collab_languages_level.collaborators_id\r\n" + 
			"    inner join languages on languages.id = collab_languages_level.languages_id\r\n" + 
			"    inner join level on level.id = collab_languages_level.level_id\r\n" + 
			"    where languages.name= :languages.name1 and level.level >= :level.level1 or languages.name = :languages.name2 and level.level >= :level.level2\r\n" + 
			"    GROUP BY collaborators.name, collaborators.fname HAVING COUNT(collaborators.fname)>1", nativeQuery = true)
	public Page<CollabLanguagesLevel> findBy2LangLevel(@Param("languages.name1")String lang1, @Param("level.level1")int lvl1, 
			@Param("languages.name2")String lang2, @Param("level.level2")int lvl2, Pageable page);
	
	
	
	
	
	
	
	@Query(value = "select * from collaborators c, collab_languages_level cll, languages l, hardskills h, collab_hardskills_level chl, frameworks f, collab_fram_level cfl, level lv1, level lv2, level lv3\r\n" + 
			"		where c.id=cll.collaborators_id and cll.languages_id=l.id and cll.level_id=lv1.id and lv1.level >= :level.level1 and l.name= :languages.name\r\n " +
			"		and c.id=chl.collaborators_id and chl.hardskills_id=h.id and chl.level_id=lv2.id and lv2.level >= :level.level2 and h.name= :hardskills.name\r\n "+
			"		and c.id=cfl.collaborators_id and cfl.frameworks_id=f.id and cfl.level_id=lv3.id and lv3.level >= :level.level3 and f.name= :frameworks.name\r\n ", nativeQuery = true)
	public Page<CollabLanguagesLevel> findBy2Lang1F(@Param("languages.name")String lang1, 
													@Param("level.level1")int lvl1, 
													@Param("hardskills.name")String hs, 
													@Param("level.level2")int lvl2,
													@Param("frameworks.name")String fram, 
													@Param("level.level3")int lvl3,Pageable page);
	
	@Query(value = "select * from collaborators c, languages l, frameworks f, hardskills h, collab_languages_level cll, collab_hardskills_level chl, collab_fram_level cfl, level lv1, level lv2, level lv3\r\n" + 
			"where c.id = cll.collaborators_id and cll.level_id=lv1.id and c.id=chl.collaborators_id and chl.level_id=lv2.id and c.id=cfl.collaborators_id and cfl.level_id=lv3.id and cll.languages_id=l.id and chl.hardskills_id=h.id and cfl.frameworks_id=f.id and\r\n" + 
			"c.name = :name"
			+ " ", nativeQuery = true)
	Page<CollabLanguagesLevel> profil(@Param("name")String name, Pageable page);
	}
