package com.academy.recipes.spring_course.service.interfaces;

import com.academy.recipes.spring_course.model.Category;


public interface CategoryService {

	Category createCategoryLabel (Category category);
	
	Boolean addCategoryToRecipe(Long recipeId, Category category);

	String removeCategoryFromRecipe(Long recipeId, Category category);
	
}
