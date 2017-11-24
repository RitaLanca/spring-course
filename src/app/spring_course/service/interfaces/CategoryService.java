package com.academy.recipes.spring_course.service.interfaces;

import com.academy.recipes.spring_course.model.Category;


public interface CategoryService {

	Category createCategoryLable (Category category);
	
	Category findCategoryById (Long categoryId);
	
	Boolean addCategoryToRecipe(Long recipeId, Category category);

	Boolean removeCategoryFromRecipe(Long recipeId, Category category);
	
	String eliminateCategoryLable (Long categoryId);
	
}
