package fr.percall.skills;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.percall.collab.Collaborators;

@Entity(name = "collab_fram_level")
@Configuration
@ComponentScan(basePackageClasses = Collaborators.class)
@ComponentScan(basePackageClasses = Level.class)
@ComponentScan(basePackageClasses = Languages.class)
public class CollabFramLevel implements Serializable{

	private static final long serialVersionUID = -4501565111740895968L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	private Collaborators collaborators;
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	private Frameworks frameworks;
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	private Level level;
	
	
	
	public CollabFramLevel() {}
	
	public CollabFramLevel(Collaborators collaborators, Frameworks frameworks, Level level) {
		super();
		this.collaborators = collaborators;
		this.frameworks = frameworks;
		this.level = level;
	}
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public Collaborators getCollaborators() {
		return collaborators;
	}
	public void setCollaborators(Collaborators collaborators) {
		this.collaborators = collaborators;
	}
	@Bean
	public Frameworks getFrameworks() {
		return frameworks;
	}
	public void setFrameworks(Frameworks frameworks) {
		this.frameworks = frameworks;
	}
	
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
	

}
