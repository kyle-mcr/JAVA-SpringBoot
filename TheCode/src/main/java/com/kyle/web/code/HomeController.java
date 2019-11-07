package com.kyle.web.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home () {
		return "Home.jsp";
	}
	
	@RequestMapping(value="/guess", method=RequestMethod.POST)
	public String guess(@RequestParam(value="guess") String guess) {
		if(guess.equals("bushido")) {
		return "redirect:/code";
	} else {
	        return "redirect:/createError";
		}
	}

	@RequestMapping("/code")
	public String code () {
		return "Code.jsp";
	}
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "A test error!");
        return "redirect:/";
	}
}
