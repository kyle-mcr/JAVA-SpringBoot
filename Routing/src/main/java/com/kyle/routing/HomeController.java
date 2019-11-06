package com.kyle.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/coding")
	@RestController
	public class HomeController {
		
		@RequestMapping("")
			public String coding(@RequestParam(value="q", required=false) String searchQuery) {
		        return "Hello Coding DOjo";
		}
		
		@RequestMapping("/python")
		public String python(@RequestParam(value="q", required=false) String searchQuery) {
	        return  "Python/Django was awesome!";
	}
		
		@RequestMapping("/java")
		public String java(@RequestParam(value="q", required=false) String searchQuery) {
	        return "Java/Spring is better!";
	}
		
			@RequestMapping("/m/{track}/{module}/{lesson}")
		    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
		    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
		}
	}
	  