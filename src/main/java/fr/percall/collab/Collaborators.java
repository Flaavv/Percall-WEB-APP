package fr.percall.collab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import fr.percall.skills.CollabLanguagesLevel;
import fr.percall.skills.Languages;




@Entity
public class Collaborators implements Serializable{

	private static final long serialVersionUID = 136033381397483968L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column
	String name;
	
	@Column(name = "fname")
	String firstName;
	
	
	
	
	
	
	
	public Collaborators() {}
	
	public Collaborators(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Bean
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return firstName;
	}

	public void setFname(String fname) {
		this.firstName = fname;
	}
	
	
	
	

}
