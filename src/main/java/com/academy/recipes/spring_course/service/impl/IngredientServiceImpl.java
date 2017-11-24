package com.academy.recipes.spring_course.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.academy.recipes.spring_course.business.dtos.IngredientRecipeDto;
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
			
		}
		
		IngredientRecipe ingredientRecipe= new IngredientRecipe(ingredientToAdd, recipeSelected);
		ingredientRecipeRepository.saveAndFlush(ingredientRecipe);

		return true;
		
	}

	@Override
	public Boolean removeIngredientFromRecipe(Long recipeId, Ingredient ingredient) {
		
		Recipe recipeSelected=recipeService.findRecipeById(recipeId);
		Ingredient ingredientSelected= ingredientRepository.findIngredientByName(ingredient.getName());
		
		if(recipeSelected==null || ingredientSelected==null) {
			return false;
		}
		
		IngredientRecipe ingredientRecipeToRemove = ingredientRecipeRepository.findIngredientRecipeByRecipeIdAndIngredientId(recipeId,ingredientSelected.getId());		
		
		ingredientRecipeRepository.delete(ingredientRecipeToRemove);		
		
		return true;
	}

	@Override
	public String eliminateCategoryLable(Long ingredientId) {
		
		Ingredient ingredientToDelete = ingredientRepository.findIngredientById(ingredientId);
		
		if (ingredientToDelete==null) {
			return "The ingredient doesn´t exist";
		}
		
		ingredientRepository.delete(ingredientToDelete);
			
		return "The ingredient was deleted";
	
	}

	@Override
	public IngredientRecipeDto setIngredient(Long recipeId, Long ingredientId, IngredientRecipe settings) {
		Recipe recipeSelected=recipeService.findRecipeById(recipeId);
		Ingredient ingredientSelected= ingredientRepository.findIngredientById(ingredientId);
		
		//Validate if recipe and ingredient exist
		if(recipeSelected==null || ingredientSelected==null )
			return null;
		
		
		IngredientRecipe ingredientExistsInRecipe= ingredientRecipeRepository.findIngredientRecipeByRecipeIdAndIngredientId(recipeId, ingredientId);
				
		//Validate if ingredient exists in the recipe
		if(ingredientExistsInRecipe==null) {
			return null;
		}
	
		
		 //UpDate the Ingredient in Recipe
		//Quantity is 0 by default in database
		ingredientExistsInRecipe.setQuantity(settings.getQuantity());
		
		if(settings.getUnitMeasure()!= null) {
			ingredientExistsInRecipe.setUnitMeasure(settings.getUnitMeasure());
		}
		
		
		ingredientRecipeRepository.saveAndFlush(ingredientExistsInRecipe);
	 		 
		 return new IngredientRecipeDto(recipeSelected.getName(),ingredientSelected.getName(),recipeSelected.getDescription(), settings.getQuantity(), settings.getUnitMeasure());
	
	}

	
}
