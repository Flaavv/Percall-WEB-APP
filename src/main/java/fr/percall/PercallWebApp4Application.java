package fr.percall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import fr.percall.collab.Collaborators;
import fr.percall.dao.CollabLangLevelRepository;
import fr.percall.dao.CollabRepository;
import fr.percall.skills.CollabLanguagesLevel;
import fr.percall.skills.Languages;
import fr.percall.skills.Level;

@SpringBootApplication
public class PercallWebApp4Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(PercallWebApp4Application.class, args);
		 
		/** CollabLangLevelRepository clRepo = ctx.getBean(CollabLangLevelRepository.class);
		 Collaborators c = new Collaborators("Zverev", "Alexander");
		 Languages l = new Languages("SQL");
		 Level lvl = new Level(3);
		 clRepo.save(new CollabLanguagesLevel(c, l, lvl)); */
		
	}

}
