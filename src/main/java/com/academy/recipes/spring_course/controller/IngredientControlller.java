package com.academy.recipes.spring_course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.recipes.spring_course.model.Ingredient;
import com.academy.recipes.spring_course.model.IngredientRecipe;
import com.academy.recipes.spring_course.service.interfaces.IngredientService;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin
public class IngredientControlller {

	@Autowired
	IngredientService ingredientService;
	
	@PostMapping("")
	public Ingredient createIngredient (@RequestBody Ingredient ingredient) {
		return ingredientService.createNewIngredient(ingredient);
	}
	
	@PostMapping("/add")
	public Boolean addIngredientToRecipe (@RequestParam("id") Long recipeId,@RequestBody Ingredient ingredient) {
		return ingredientService.addIngredientToRecipe(recipeId, ingredient);
	}
	
	@DeleteMapping("/remove")
	public Boolean removeIngredientToRecipe (@RequestParam("id") Long recipeId,@RequestBody Ingredient ingredient) {
		return ingredientService.removeIngredientFromRecipe(recipeId, ingredient);
	}
	
	@DeleteMapping("")
	public String eliminateIngredientLable (@RequestParam("id") Long ingredientId) {
		return ingredientService.eliminateCategoryLable(ingredientId);
	}
	
	@PostMapping("/set")
	public IngredientRecipe setIngredient (@RequestParam("recipeId") Long recipeId,@RequestBody Ingredient ingredientInRecipe, @RequestBody IngredientRecipe settings) {
		return ingredientService.setIngredient(recipeId, ingredientInRecipe, settings );
	}
	
}
