package fr.percall.controller;

import java.lang.annotation.Repeatable;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.percall.collab.Collaborators;
import fr.percall.dao.CollabFramLevelRepository;
import fr.percall.dao.CollabHardskillsLevelRepository;
import fr.percall.dao.CollabLangLevelRepository;
import fr.percall.dao.CollabRepository;
import fr.percall.dao.FrameworksRepository;
import fr.percall.dao.HardskillsRepository;
import fr.percall.dao.LanguagesRepository;
import fr.percall.dao.LevelRepository;
import fr.percall.skills.CollabFramLevel;
import fr.percall.skills.CollabHardSkillsLevel;
import fr.percall.skills.CollabLanguagesLevel;
import fr.percall.skills.Frameworks;
import fr.percall.skills.Hardskills;
import fr.percall.skills.Languages;
import fr.percall.skills.Level;

@Controller
public class CollabLangLevelController {
	
	@Autowired
	private CollabLangLevelRepository clbRepo;
	@Autowired
	private CollabRepository collabRepo;
	@Autowired
	private LevelRepository lvlRepo;
	@Autowired
	private LanguagesRepository lgRepo;
	@Autowired
	private HardskillsRepository hskRepo;
	@Autowired
	private FrameworksRepository framRepo;
	@Autowired
	private CollabFramLevelRepository cflRepo;
	@Autowired
	private CollabHardskillsLevelRepository chlRepo;

	@RequestMapping(value="/cbl")
	public String collab(Model model, 
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue ="35")int s) {
			Page<CollabLangLevelRepository> cll = clbRepo.showMeAll(PageRequest.of(p, s));
		model.addAttribute("listCollabLangLvl", cll.getContent());
		int[] pages = new int[cll.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		
		return "cll";
		
		
	}
	
/** Code pour filtrer avec une techno (language) et 1 niveau */ 
	
	/** @RequestMapping(value = "/search")
	public String searchByL(Model model,
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue = "10")int s,
			@RequestParam(name="keyLanguages", defaultValue = "")String languagesx,
			@RequestParam(name="keyLevel", defaultValue = "0")int levelx) {
		Page<CollabLanguagesLevel> searchByL = clbRepo.findByLangLevel(languagesx, levelx, PageRequest.of(p, s));	
		List<Languages> lg = lgRepo.findAll();
		model.addAttribute("listCollab", searchByL.getContent());
		int[] pages = new int[searchByL.getTotalPages()];
		model.addAttribute("LanguagesList", lg);
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("keyLanguages", languagesx);
		model.addAttribute("keyLevel", levelx);
		
		return "search";
	} */
	
	/** Code pour filtrer avec 2 technos et 2 niveaux */
	
/**	@RequestMapping(value = "/search")
	public String searchBy2L(Model model,
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue = "14")int s,
			@RequestParam(name="keyLanguages", defaultValue = "")String lang1,
			@RequestParam(name="keyLevel", defaultValue = "0")int lvl1,
			@RequestParam(name="keyLanguages2", defaultValue = "")String lang2,
			@RequestParam(name="keyLevel2", defaultValue = "0")int lvl2){
		Page<CollabLanguagesLevel> searchBy2L = clbRepo.findBy2LangLevel(lang1, lvl1, lang2, lvl2, PageRequest.of(p, s));	
		List<Languages> lg = lgRepo.findAll();
		model.addAttribute("listCollab", searchBy2L.getContent());
		int[] pages = new int[searchBy2L.getTotalPages()];
		model.addAttribute("LanguagesList", lg);
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("keyLanguages", lang1);
		model.addAttribute("keyLevel", lvl1);
		model.addAttribute("keyLanguages2", lang2);
		model.addAttribute("keyLevel2", lvl2);
		
		return "search";
	} */
	
	/**@RequestMapping(value = "/profiles")
	public String search(Model model,
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue = "14")int s,
			@RequestParam(name = "profil", defaultValue = "")String name) {
			
			Page<CollabLanguagesLevel> x = clbRepo.profil("%"+name+"%", PageRequest.of(p, s));
			model.addAttribute("listprofil",x.getContent());
			List<CollabFramLevel> cfl = cflRepo.cfl("%"+name+"%");
			Page<CollabHardSkillsLevel> chl = chlRepo.chl("%"+name+"%", PageRequest.of(p, s));
			model.addAttribute("hard", chl.getContent());
			int[] pages = new int[x.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("size", s);
			model.addAttribute("pageCourante", p);
			model.addAttribute("profil", name);
			model.addAttribute("fram", cfl);
			
			
		
			return "/profiles";
		
	}
	
	/**@RequestMapping(value="/profiles")
	public String collabll(Model model, 
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue ="30")int s, 
			@RequestParam(name="keyWord", defaultValue = "") String name){
		
		Page<CollabLanguagesLevel> collabll = clbRepo.profil(name, PageRequest.of(p, s));
		
		model.addAttribute("listCollab", collabll.getContent());
		int[] pages = new int[collabll.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("keyWord", name);
		
		
		return "profiles";
		
		
	} */
	/** Code pour filtrer avec 1 techno, 1 framework, 1 hardskill et leurs niveaux respectifs */
	
	@RequestMapping(value = "/search")
	public String search(Model model,
			@RequestParam(name="pages", defaultValue = "0")int p,
			@RequestParam(name="size", defaultValue = "50")int s,
			@RequestParam(name="keyLanguages", defaultValue = "")String lang1,
			@RequestParam(name="keyLevel1", defaultValue = "0")int lvl1,
			@RequestParam(name="keyHS", defaultValue = "")String hs,
			@RequestParam(name="keyLevel2", defaultValue = "0")int lvl2,
			@RequestParam(name="keyFram", defaultValue = "")String fram,
			@RequestParam(name="keyLevel3", defaultValue = "0")int lvl3
			){
		List<CollabLanguagesLevel> search = clbRepo.findBy2Lang1F(lang1, lvl1, hs, lvl2, fram, lvl3);	
		List<Languages> lg = lgRepo.findAll();
		List<Hardskills> hsk = hskRepo.findAll();
		List<Frameworks> fra = framRepo.findAll();
		List<CollabFramLevel> cfl = cflRepo.findAll();
		List<CollabHardSkillsLevel> chl = chlRepo.findAll();
		List<CollabLanguagesLevel> cll = clbRepo.findAll();
		
		model.addAttribute("CLL", cll);
		model.addAttribute("CFL", cfl);
		model.addAttribute("CHL", chl);
		model.addAttribute("LanguagesList", lg);
		model.addAttribute("HardskillsList", hsk);
		model.addAttribute("FramList", fra);
		
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("keyLanguages", lang1);
		model.addAttribute("keyLevel1", lvl1);
		model.addAttribute("keyHS", hs);
		model.addAttribute("keyLevel2", lvl2);
		model.addAttribute("keyFram", fram);
		model.addAttribute("keyLevel3", lvl3);
		
		
		return "search";
	}
	
	@RequestMapping(value = "/profiles")
	public String prof(Model model,
			@RequestParam(name="profil", defaultValue = "")String name) {
			List<CollabHardSkillsLevel> y = chlRepo.chl(name);
			List<CollabLanguagesLevel> x = clbRepo.profil(name);
			List<CollabFramLevel> z = cflRepo.cfl(name);
			model.addAttribute("list2", y);
			model.addAttribute("list", x);
			model.addAttribute("list3", z);
			model.addAttribute("profil", name);
			model.addAttribute("profil", name);
			model.addAttribute("profil", name);
			return "/profiles";
	}
	
	
	
	
	@RequestMapping(value = "/formEntity", method=RequestMethod.GET)
	public String savee(Model model) {
		
		List<Hardskills> h = hskRepo.findAll();
		List<Frameworks> f = framRepo.findAll();
		List<Languages> lg = lgRepo.findAll();
		List<Level> lv = lvlRepo.findAll();
		model.addAttribute("HardskillsList", h);
		model.addAttribute("FramList", f);
		model.addAttribute("LanguagesList", lg);
		model.addAttribute("LevelList", lv);
		
		return "formEntity";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String save(Model model, Collaborators c) {
		collabRepo.save(c);
		return "form";
	}
	
	@PostMapping(value= "/saveEnt")
	public String saveEnt(Model model, Collaborators c, CollabHardSkillsLevel h, 
									   CollabLanguagesLevel f, CollabFramLevel l) {
		collabRepo.save(c);
		cflRepo.save(l);
		chlRepo.save(h);
		clbRepo.save(f);
		
		return "ConfirmationEntity";
	}
	
	/**
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String save(Model model, CollabHardSkillsLevel chl, CollabFramLevel cfl, 
			CollabLanguagesLevel cll, Level lv) {
		chlRepo.save(chl);
		cflRepo.save(cfl);
		clbRepo.save(cll);
		return "ConfirmationEntity";
	} 
	
*/
	
}
