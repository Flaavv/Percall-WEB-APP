package fr.percall.skills;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Level implements Serializable {

	private static final long serialVersionUID = 934629594878369229L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column
	int level;
	
	
	public Level() {}
	public Level(int level) {
		super();
		
		this.level = level;
	}
	@Bean
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
