package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienDAO;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	@Autowired
	AlienDAO dao;

	@RequestMapping("/")
	public String home() {
		System.out.println("Inside Home!!");
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		System.out.println("Add Alien Home!!");
		
		dao.save(alien);
		
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		System.out.println("Retrieve Alien: " + aid);
		
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = dao.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		
		return mv;
	}
	
	
	// ------------------------------- REST pozivi ------------------------------------------------------
	// @ResponseBody stavljamo uvek kada gradimo REST web aplikaciju. 
	// Moze i da se navede odmah iznad imena klase @RestController, umesto @Controller i to je ekvivalent @ResponseBody (ne mora se ponaosob navoditi). 
	
	
	@RequestMapping("/api/aliens")
	@ResponseBody
	public List<Alien> getAllAliens(){
		System.out.println("REST poziv za \"aliens\"");
		
		// bice konvertovano u JASON listu, a to radi maven jer je importovao jackson-core.jar (java object u jason format)
		return dao.findAll();  // medjutim u pom.xml dodali smo jackson-dataformat-xml pa ce biti konvertovano u xml podatak.
	}
	
	@RequestMapping("/api/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getSingleAlien(@PathVariable("aid") int aid){
		System.out.println("REST poziv za SINGLE \"aliena\"");
		
		// bice konvertovano u JASON objekat, a to radi maven jer je importovao jackson-core.jar (java object u jason format)
		return dao.findById(aid); // medjutim u pom.xml dodali smo jackson-dataformat-xml pa ce biti konvertovano u xml podatak.
	}
	
	
	
	@PostMapping("/api/alien")
	@ResponseBody
	public Alien add(Alien alien) {
		System.out.println("Add Alien REST!!");
		
		dao.save(alien);
		
		return alien;
	}
	
	@DeleteMapping("/api/alien/{aid}")
	@ResponseBody
	public String delete(@PathVariable int aid) {
		System.out.println("Delete Alien REST!!");
		
		Alien alien = dao.getById(aid);
		dao.delete(alien);
		
		return "deleted";
	}
	
	@PutMapping("/api/alien")
	@ResponseBody
	public Alien update(Alien alien) {
		System.out.println("Update Alien REST!!");
		
		dao.save(alien);
		
		return alien;
	}
	
	
	
	
	
	
	
}
