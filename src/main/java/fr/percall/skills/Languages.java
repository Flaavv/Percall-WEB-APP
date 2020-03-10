package fr.percall.skills;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import fr.percall.collab.Collaborators;



@Entity(name = "languages")
@Component
public class Languages implements Serializable {

	private static final long serialVersionUID = 2920338393086786597L;
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer id;
	
	@Column
	String name;
	
	
	
	
	public Languages() {}
	public Languages(String name) {
		this.name = name;
		
	}
	
		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}
