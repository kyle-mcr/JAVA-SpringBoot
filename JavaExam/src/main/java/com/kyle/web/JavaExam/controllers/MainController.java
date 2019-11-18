package com.kyle.web.JavaExam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyle.web.JavaExam.models.Idea;
import com.kyle.web.JavaExam.models.User;
import com.kyle.web.JavaExam.repositories.IdeaRepository;
import com.kyle.web.JavaExam.services.IdeaService;
import com.kyle.web.JavaExam.services.UserService;
import com.kyle.web.JavaExam.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final IdeaService ideaService;
	private final IdeaRepository ideaRepository;
	private final UserValidator userValidator;
	public MainController(
			UserService userService,
			IdeaService ideaService,
			IdeaRepository ideaRepository,
			UserValidator userValidator
			) {
		this.userService = userService;
		this.ideaService = ideaService;
		this.ideaRepository = ideaRepository;
		this.userValidator = userValidator;
	}
	
	@GetMapping("/")
	public String home(@ModelAttribute("user") User user,@ModelAttribute("user2") User user2) {
		
		return "loginreg.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginreg.jsp";
		} else {
			User u = userService.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/";
		}
		
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, BindingResult result, @RequestParam("email_l") String email, @RequestParam("password_l") String password, HttpSession session, Model model) {
		if(userService.authenticateUser(email, password) == true) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Invalid login");
			return "loginreg.jsp";
		}
		
	}
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		List<Idea> ideas = ideaService.findAllIdeas();
		model.addAttribute("ideas", ideas);
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", u);
		return "home.jsp";
	}
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Idea i = ideaService.findIdeaById(id);
		model.addAttribute("idea", i);
		return "show.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Idea i = ideaService.findIdeaById(id);
		model.addAttribute("idea", i);
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String actuallyEdit(@PathVariable("id") Long id, @Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			Idea old = ideaService.findIdeaById(id);
			idea.setCreator(old.getCreator());
			idea.setLikers(old.getLikers());
			ideaRepository.save(idea);
			return "redirect:/home";
		}
	}
	@GetMapping("/new")
	public String createIdea(@ModelAttribute("idea") Idea idea) {
		return "new.jsp";
	}
	@PostMapping("/new")
	public String createIdeaPost(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			User u = userService.findUserById((Long) session.getAttribute("userId"));
			idea.setCreator(u);
			Idea m = ideaRepository.save(idea);
			return "redirect:/home";
		}
	}
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		Idea i = ideaService.findIdeaById(id);
		i.getLikers().add(u);
		ideaRepository.save(i);
		return "redirect:/home";
	}
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		Idea m = ideaService.findIdeaById(id);
		for(int i = 0; i < m.getLikers().size(); i++) {
			if(u.getId() == m.getLikers().get(i).getId()) {
				m.getLikers().remove(i);
				break;
			}
		}
		ideaRepository.save(m);
		return "redirect:/home";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		ideaRepository.deleteById(id);
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}