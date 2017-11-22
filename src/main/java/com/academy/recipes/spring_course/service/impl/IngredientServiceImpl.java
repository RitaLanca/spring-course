package com.academy.recipes.spring_course.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.academy.recipes.spring_course.model.Ingredient;
import com.academy.recipes.spring_course.model.IngredientRecipe;
import com.academy.recipes.spring_course.model.Recipe;
import com.academy.recipes.spring_course.repository.IngredientRecipeRepository;
import com.academy.recipes.spring_course.repository.IngredientRepository;
import com.academy.recipes.spring_course.service.interfaces.IngredientService;
import com.academy.recipes.spring_course.service.interfaces.RecipeService;

@Component
@Transactional
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	IngredientRecipeRepository ingredientRecipeRepository;
	
	
	@Autowired RecipeService recipeService;
	
	@Override
	public Ingredient createNewIngredient(Ingredient ingredient) {
		return ingredientRepository.saveAndFlush(ingredient);
				 
	}
	
	public Boolean addIngredientToRecipe(Long recipeId, Ingredient ingredient) {
	
		Recipe recipeSelected=recipeService.findRecipeById(recipeId);
		Ingredient ingredientToAdd= ingredientRepository.findIngredientByName(ingredient.getName());	
		
		if(recipeSelected==null) {
			return false;
		}
		
		//Checking if ingredient already exists
		
		if(ingredientToAdd==null) {
			ingredientToAdd= createNewIngredient(ingredient);
			return true;						
		}
		
		IngredientRecipe ingredientRecipe= new IngredientRecipe(ingredientToAdd, recipeSelected);
		ingredientRecipeRepository.saveAndFlush(ingredientRecipe);

		return true;
		
	}

}
