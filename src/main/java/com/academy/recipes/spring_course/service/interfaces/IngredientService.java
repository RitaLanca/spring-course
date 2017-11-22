package com.academy.recipes.spring_course.service.interfaces;

import com.academy.recipes.spring_course.model.Ingredient;

public interface IngredientService {

	Ingredient createNewIngredient(Ingredient ingredient);
	
	Boolean addIngredientToRecipe(Long recipeId, Ingredient ingredient);
}
