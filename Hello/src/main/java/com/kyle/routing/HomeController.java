package com.kyle.routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


	@RestController
	public class HomeController {
		
		@RequestMapping("/")
			public String coding(@RequestParam(value="q", required=false) String searchQuery) {
				if(searchQuery == null) {
					return "You searched for nothing";
				} else {
		        return "You searched for: " + searchQuery;
				}
		}
		
	}
	  