package com.kyle.routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class DojoController {
		
		@RequestMapping("/dojo")
			public String dojo(@RequestParam(value="q", required=false) String searchQuery) {
		        return "The dojo is awesome!";
		}
		
		@RequestMapping("/burbank-dojo")
		public String burbank(@RequestParam(value="q", required=false) String searchQuery) {
	        return "Burbank Dojo is located in Southern California";
	}
		
		@RequestMapping("/san-jose")
		public String jose(@RequestParam(value="q", required=false) String searchQuery) {
	        return "SJ dojo is the headquarters";
	}
	}