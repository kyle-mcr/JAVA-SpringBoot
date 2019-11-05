package com.kyle.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	@RequestMapping("/")
	public String message() {
		return "Hello you cool mf";
	}
	@RequestMapping("/random")
	public String random() {
		return "Hello you cool mf welcome to SPringBoot";
	}
}
