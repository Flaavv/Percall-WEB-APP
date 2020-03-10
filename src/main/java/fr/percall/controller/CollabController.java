package fr.percall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.percall.collab.Collaborators;
import fr.percall.dao.CollabLangLevelRepository;
import fr.percall.dao.CollabRepository;
import fr.percall.dao.LanguagesRepository;
import fr.percall.dao.LevelRepository;
import fr.percall.skills.CollabLanguagesLevel;
import fr.percall.skills.Languages;
import fr.percall.skills.Level;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

@Controller
public class CollabController {
	
	@Autowired
	private CollabRepository collabRepo;
	@Autowired
	CollabLangLevelRepository cllRepo;
	@Autowired
	LanguagesRepository lgRepo;
	@Autowired
	LevelRepository lvlRepo;
	
	@RequestMapping(value="/index")
	public String collab(Model model, 
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue ="30")int s, 
			@RequestParam(name="keyWord", defaultValue = "") String name){
		
		List<CollabLanguagesLevel> collab = cllRepo.findAll();
		
		model.addAttribute("listCollab", collab);
		
		
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("keyWord", name);
		
		
		return "collab";
		
		
	}
	
	

	
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String delete(Integer id) {
		collabRepo.deleteById(id);
		return "redirect:/index";
		
	}
	
	/** @RequestMapping(value = "/form", method=RequestMethod.GET)
	public String save(Model model) {
		model.addAttribute("collaborators", new Collaborators());
		return "formAdd";
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String save(Model model, Collaborators collaborators) {
		collabRepo.save(collaborators);
		return "Confirmation";
	} */

	

}
