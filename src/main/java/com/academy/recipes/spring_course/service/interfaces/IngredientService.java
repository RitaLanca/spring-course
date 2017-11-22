package com.academy.recipes.spring_course.service.interfaces;

import com.academy.recipes.spring_course.model.Ingredient;
import com.academy.recipes.spring_course.model.IngredientRecipe;

public interface IngredientService {

	Ingredient createNewIngredient(Ingredient ingredient);
	
	Boolean addIngredientToRecipe(Long recipeId, Ingredient ingredient);

	Boolean removeIngredientFromRecipe(Long recipeId, Ingredient ingredient);

	String eliminateCategoryLable(Long ingredientId);

	IngredientRecipe setIngredient(Long recipeId, Ingredient ingredientInRecipe, IngredientRecipe settings);
}
