package fr.percall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import fr.percall.dao.LanguagesRepository;
import fr.percall.skills.Languages;

@Controller
public class LanguagesController {
	
	@Autowired
	private LanguagesRepository langRepo;
	
	@RequestMapping(value="/languages")
	public String languages(Model model, 
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue ="10")int s, 
			@RequestParam(name="keyWord", defaultValue = "") String mc){
		
		Page<Languages> languages = langRepo.chercher("%"+mc+"%", PageRequest.of(p, s));
		model.addAttribute("listLanguages", languages.getContent());
		int[] pages = new int[languages.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("keyWord", mc);
		return "languages";
		
		
	}
	
	

	
	@RequestMapping(value = "/deleteLanguages",method=RequestMethod.GET)
	public String delete(Integer id) {
		langRepo.deleteById(id);
		return "redirect:/languages";
		
	}
	
	@RequestMapping(value = "/formLanguages", method=RequestMethod.GET)
	public String formLanguages(Model model) {
		model.addAttribute("languages", new Languages());
		return "formLanguages";
	}
	
	@RequestMapping(value = "/saveLanguages", method=RequestMethod.POST)
	public String save(Model model, Languages languages) {
		langRepo.save(languages);
		return "ConfirmationL";
	}

}
