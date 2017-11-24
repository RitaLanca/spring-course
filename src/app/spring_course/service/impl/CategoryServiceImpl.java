package com.academy.recipes.spring_course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.academy.recipes.spring_course.model.Category;
import com.academy.recipes.spring_course.model.CategoryRecipe;
import com.academy.recipes.spring_course.model.Recipe;
import com.academy.recipes.spring_course.repository.CategoryRecipeRepository;
import com.academy.recipes.spring_course.repository.CategoryRepository;
import com.academy.recipes.spring_course.service.interfaces.CategoryService;
import com.academy.recipes.spring_course.service.interfaces.RecipeService;

@Component
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryRecipeRepository categoryRecipeRepository;
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	CategoryService categoryService;
	
	@Override
	public Category createCategoryLable(Category category) {
		return categoryRepository.saveAndFlush(category);
	}

	
	@Override
	public Boolean addCategoryToRecipe(Long recipeId, Category category) {
		Recipe recipeSelected=recipeService.findRecipeById(recipeId);
		Category categoryToAdd= categoryRepository.findCategoryByName(category.getName());
		
		if(recipeSelected==null || categoryToAdd==null) {
			return false;
		}
		
		
		CategoryRecipe categoryInRecipe= new CategoryRecipe(categoryToAdd, recipeSelected);
		
		categoryRecipeRepository.saveAndFlush(categoryInRecipe);
		
		return true;
		
	}


	@Override
	public Boolean removeCategoryFromRecipe(Long recipeId, Category category) {
		
		Recipe recipeSelected=recipeService.findRecipeById(recipeId);
		Category categorySelected= categoryRepository.findCategoryByName(category.getName());
		
		if(recipeSelected==null || categorySelected==null) {
			return false;
		}
		
		CategoryRecipe categoryRecipeToRemove = categoryRecipeRepository.findCategoryRecipeByRecipeIdAndCategoryId(recipeId,categorySelected.getId());		
		
		categoryRecipeRepository.delete(categoryRecipeToRemove);		
		
		return true;
		
	}


	@Override
	public String eliminateCategoryLable(Long categoryId) {
		
		Category categoryToDelete = categoryRepository.findCategoryById(categoryId);
	
		if (categoryToDelete==null) {
			return "The category doesn´t exist";
		}
		
		categoryRepository.delete(categoryToDelete);
			
		return "The category was deleted";
	
}


	@Override
	public Category findCategoryById(Long categoryId) {
		
		return categoryRepository.findCategoryById(categoryId);
	}





}
