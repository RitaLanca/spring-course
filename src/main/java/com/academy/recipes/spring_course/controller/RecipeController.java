package com.academy.recipes.spring_course.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.recipes.spring_course.model.Recipe;
import com.academy.recipes.spring_course.service.interfaces.AuthorService;
import com.academy.recipes.spring_course.service.interfaces.RecipeService;



@RestController
@RequestMapping("/recipe")
@CrossOrigin
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@PostMapping("/add")
	public String createRecipe(@RequestBody Recipe recipe, @RequestParam Long authorId) {
		return recipeService.createRecipe(recipe, authorId);
	}

	@RequestMapping("/searchByName")
	public List<Recipe> findRecipeByName(@RequestParam ("name") String name) {
		return recipeService.findRecipeByRecipeName(name);
	}
	
	@RequestMapping(value="/searchByAuthorName")
	public List<Recipe> findRecipeByAuthorName(@RequestParam("author") String authorName) {
		return recipeService.findRecipeByAuthor(authorName);
	}
//
//	
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	public Author findUserById(@PathVariable Long id) {
//		return recipeRepository.findOne(id);
//	}
//	
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public Author updateUser(@PathVariable Long id, @RequestBody Author user) {
//		Author existingUser = authorRepository.findOne(id);
//		BeanUtils.copyProperties(user, existingUser);
//		return authorRepository.saveAndFlush(existingUser);
//	}
//	
//	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//	public void deleteUser(@PathVariable Long id) {
//		Author existingUser = authorRepository.findOne(id);
//		authorRepository.delete(existingUser);
//	}
	
}
