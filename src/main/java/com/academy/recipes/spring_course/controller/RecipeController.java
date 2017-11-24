package com.academy.recipes.spring_course.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.recipes.spring_course.business.dtos.RecipeDto;
import com.academy.recipes.spring_course.model.Recipe;
import com.academy.recipes.spring_course.service.interfaces.RecipeService;



@RestController
@RequestMapping("/recipe")
@CrossOrigin
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value = "/")
	public List<RecipeDto> findAllRecipes() {
		return recipeService.findAllRecipes();
	}

	
	@PostMapping("/add")
	public String createRecipe(@RequestBody Recipe recipe, @RequestParam ("authorId") Long authorId) {
		return recipeService.createRecipe(recipe, authorId);
	}

	@RequestMapping("/searchByName")
	public List<Recipe> findRecipeByName(@RequestParam ("name") String name) {
		return recipeService.findRecipeByRecipeName(name);
	}
	
	@RequestMapping(value="/searchByAuthorId")
	public List<Recipe> findRecipeByAuthorId(@RequestParam("authorId") Long authorId) {
		return recipeService.findRecipeByAuthorId(authorId);
	}
	

	@DeleteMapping("/{recipeId}")
	public String deleteRecipe(@PathVariable ("recipeId") Long id) {
		return recipeService.deleteRecipe(id);
		
	}
	
	
	@PutMapping("/update")
	public Recipe editRecipe(@RequestParam ("id") Long id, @RequestBody Recipe recipe) {
		return recipeService.updateRecipe(id, recipe);
	}
	

	
}
