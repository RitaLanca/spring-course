package com.academy.recipes.spring_course.service.interfaces;

import java.util.List;

import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.model.Recipe;

public interface RecipeService {
	
	String createRecipe (Recipe recipe, Long authorId);
	
	List<Recipe> findRecipeByRecipeName(String name);
	
	List<Recipe> findRecipeByAuthor(String authorName);
	
	List<Recipe> findRecipeByAuthorId(Long authorId);
	
}
