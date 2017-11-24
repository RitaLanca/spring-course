package com.academy.recipes.spring_course.service.interfaces;

import java.util.List;

import com.academy.recipes.spring_course.model.Recipe;

public interface RecipeService {
	
	String createRecipe (Recipe recipe, Long authorId);
	
	Recipe findRecipeById(Long recipeId);
	
	List<Recipe> findRecipeByRecipeName(String name);
	
//	List<Recipe> findRecipeByAuthor(String authorName);
	
	List<Recipe> findRecipeByAuthorId(Long authorId);
	
	String deleteRecipe (Long recipeId);
	
	Recipe updateRecipe (Long recipeId, Recipe recipe);
	
}
