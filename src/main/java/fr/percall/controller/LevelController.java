package fr.percall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.percall.dao.LevelRepository;

@Controller
public class LevelController {
	
	@Autowired
	private LevelRepository lvlRepo;
	
	
	
}
