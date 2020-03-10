package fr.percall.skills;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import fr.percall.collab.Collaborators;

@Entity
@Configuration
@ComponentScan(basePackageClasses = Collaborators.class)
@ComponentScan(basePackageClasses = Level.class)
@ComponentScan(basePackageClasses = Languages.class)
public class CollabLanguagesLevel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	public Collaborators collaborators;
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	public Languages languages;
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	public Level level;
	
	public CollabLanguagesLevel() {}
	
	public CollabLanguagesLevel(Collaborators collaborators, Languages languages, Level level) {
		super();
		this.collaborators = collaborators;
		this.languages = languages;
		this.level = level;
	}
	@Bean
	public Collaborators getCollaborators() {
		return collaborators;
	}
	public void setCollaborators(Collaborators collaborators) {
		this.collaborators = collaborators;
	}
	@Bean
	public Languages getLanguages() {
		return languages;
	}
	public void setLanguages(Languages languages) {
		this.languages = languages;
	}
	
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
}
