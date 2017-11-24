package com.academy.recipes.spring_course.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin
public class HomeController {

	@RequestMapping("")
	public String home() {
		return "Hello";
	}
}
