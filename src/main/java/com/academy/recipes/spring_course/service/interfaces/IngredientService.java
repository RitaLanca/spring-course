package com.academy.recipes.spring_course.service.interfaces;

import com.academy.recipes.spring_course.business.dtos.IngredientRecipeDto;
import com.academy.recipes.spring_course.model.Ingredient;
import com.academy.recipes.spring_course.model.IngredientRecipe;

public interface IngredientService {
		Ingredient createNewIngredient(Ingredient ingredient);
	
	Boolean addIngredientToRecipe(Long recipeId, IngredientRecipeDto ingredient);

	Boolean removeIngredientFromRecipe(Long recipeId, Ingredient ingredient);

	String eliminateCategoryLable(Long ingredientId);

	IngredientRecipeDto setIngredient(Long recipeId, Long ingredientId, IngredientRecipe settings);
}
