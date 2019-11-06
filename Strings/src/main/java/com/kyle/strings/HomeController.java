package com.kyle.strings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String message() {
		return "Hello you cool mf";
	}
	@RequestMapping("/random")
	public String random() {
		return "Hello you cool mf welcome to SPringBoot";
	}
}
  