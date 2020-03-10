package fr.percall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.percall.dao.CollabLangLevelRepository;
import fr.percall.dao.LanguagesRepository;
import fr.percall.skills.CollabLanguagesLevel;
import fr.percall.skills.Languages;

@Controller
public class HomeController {
	
	@Autowired
	private LanguagesRepository langRepo;
	
	@RequestMapping(value="/home")
	public String languages(Model model, 
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue ="35")int s) {
			Page<Languages> languages = langRepo.showLanguages(PageRequest.of(p, s));
		model.addAttribute("listLang", languages.getContent());
		int[] pages = new int[languages.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		
		return "home";
}
}