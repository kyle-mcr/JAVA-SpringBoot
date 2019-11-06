package com.kyle.strings;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")

		public String index(@RequestParam(value="q", required=false) String searchQuery) {
	        return "You searched for: " + searchQuery;
	}
	
		@RequestMapping("/m/{track}/{module}/{lesson}")
	    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
	    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
	}
}
  