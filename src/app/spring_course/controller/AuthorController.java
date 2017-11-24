package com.academy.recipes.spring_course.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.service.interfaces.AuthorService;

@RestController
@RequestMapping("/author")
@CrossOrigin
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/add")
	public String registerAuthor (@RequestBody Author author) {
		authorService.registerAuthor(author);
			if(author==null) {
				return "Author wasn't created";
			} else
			return "Author was created";
		 
	}
	
	// @RequestParam means it is a parameter from the GET or POST request
	@PutMapping("/update")
	public Author updateAuthor (@RequestParam ("id") Long id, @RequestBody Author author) {
		return authorService.updateAuthor(id, author);
	}
	
	@GetMapping("/search")
	public List<Author> findAuthorByName (@RequestParam("name") String name) {
		return authorService.findAuthorByName(name);	
	
	}
	
	@GetMapping
	public List<Author> findAuthors() {	
		return authorService.findAll();
	
	}
	
	@DeleteMapping("/{userId}")
	public void deleteAuthor (@PathVariable("userId") Long id) {
		authorService.deleteAuthor(id);	
	
	}
	
}
