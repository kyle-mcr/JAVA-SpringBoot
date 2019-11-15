package com.kyle.web.JavaPlate.controllers;

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

import com.kyle.web.JavaPlate.models.Movie;
import com.kyle.web.JavaPlate.models.User;
import com.kyle.web.JavaPlate.repositories.MovieRepository;
import com.kyle.web.JavaPlate.services.MovieService;
import com.kyle.web.JavaPlate.services.UserService;
import com.kyle.web.JavaPlate.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final MovieService movieService;
	private final MovieRepository movieRepository;
	private final UserValidator userValidator;
	public MainController(
			UserService userService,
			MovieService movieService,
			MovieRepository movieRepository,
			UserValidator userValidator
			) {
		this.userService = userService;
		this.movieService = movieService;
		this.movieRepository = movieRepository;
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
		List<Movie> movies = movieService.findAllMovies();
		model.addAttribute("movies", movies);
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", u);
		return "home.jsp";
	}
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Movie m = movieService.findMovieById(id);
		model.addAttribute("movie", m);
		return "show.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Movie m = movieService.findMovieById(id);
		model.addAttribute("movie", m);
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String actuallyEdit(@PathVariable("id") Long id, @Valid @ModelAttribute("movie") Movie movie, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			Movie old = movieService.findMovieById(id);
			movie.setCreator(old.getCreator());
			movie.setLikers(old.getLikers());
			movieRepository.save(movie);
			return "redirect:/home";
		}
	}
	@GetMapping("/new")
	public String createMovie(@ModelAttribute("movie") Movie movie) {
		return "new.jsp";
	}
	@PostMapping("/new")
	public String createMoviePost(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			User u = userService.findUserById((Long) session.getAttribute("userId"));
			movie.setCreator(u);
			Movie m = movieRepository.save(movie);
			return "redirect:/home";
		}
	}
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		Movie m = movieService.findMovieById(id);
		m.getLikers().add(u);
		movieRepository.save(m);
		return "redirect:/home";
	}
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		Movie m = movieService.findMovieById(id);
		for(int i = 0; i < m.getLikers().size(); i++) {
			if(u.getId() == m.getLikers().get(i).getId()) {
				m.getLikers().remove(i);
				break;
			}
		}
		movieRepository.save(m);
		return "redirect:/home";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		movieRepository.deleteById(id);
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}