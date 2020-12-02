package fr.percall.skills;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.percall.collab.Collaborators;

@Entity(name = "collab_hardskills_level")
@Configuration
@ComponentScan(basePackageClasses = Collaborators.class)
@ComponentScan(basePackageClasses = Level.class)
@ComponentScan(basePackageClasses = Hardskills.class)
public class CollabHardSkillsLevel implements Serializable {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Collaborators collaborators;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Hardskills hardskills;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Level level;
	
	public CollabHardSkillsLevel() {}
	
	public CollabHardSkillsLevel(Collaborators collaborators, Hardskills hardskills, Level level) {
		super();
		this.collaborators = collaborators;
		this.hardskills = hardskills;
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
	public Hardskills getHardskills() {
		return hardskills;
	}
	public void setHardskills(Hardskills hardskills) {
		this.hardskills = hardskills;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
	
}
