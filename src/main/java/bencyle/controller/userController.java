package bencyle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import bencyle.Entity.user;
import bencyle.repository.userRepoDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class userController {

	@Autowired
	userRepoDao repo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/users") 	
	public List<user> usersList() {
		return repo.findAll();
	}
	
	@RequestMapping("/user/{id}")
	public user userList(@PathVariable int id) {
			return repo.findById(id).get();
		}
	
	
	@PostMapping("/save")
	public RedirectView save(@RequestParam int id, String name, String pass, RedirectAttributes ra) {
		user newuser = new user();
		newuser.setId(id);
		newuser.setName(name);
		newuser.setPass(pass);
		
		if(!repo.findById(id).isPresent()) {
			repo.save(newuser);
			return new RedirectView("users");
		} else {
			return new RedirectView("users");
		}
		
	}
	
	@RequestMapping("/delete/{id}")
	public RedirectView delete(@PathVariable int id) {
		if(!repo.findById(id).isPresent()) {
			return new RedirectView("../users");
		} else {
			repo.deleteById(id);
			return new RedirectView("../users");
		}
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id, Model model) {
		user data  = repo.findById(id).get();
		model.addAttribute("id",data.getId());
		model.addAttribute("name",data.getName());
		model.addAttribute("pass",data.getPass());
		return new ModelAndView("updateuser");
	}
	
	@RequestMapping("/saveUpdates/{id}")
	public RedirectView saveChanges(@PathVariable int id, @RequestParam int id2,String name, String pass) {
		if(repo.findById(id).isPresent()) {
			user updateeduser = new user();
			updateeduser.setId(id2);
			updateeduser.setName(name);
			updateeduser.setPass(pass);
			repo.save(updateeduser);
			return new RedirectView("../users");
		} else {
			return new RedirectView("../users");
		}
	}

}
