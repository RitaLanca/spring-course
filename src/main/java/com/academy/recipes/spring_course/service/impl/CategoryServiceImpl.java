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
	
	@Override
	public Category createCategoryLabel(Category category) {
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
	public String removeCategoryFromRecipe(Long recipeId, Category category) {
		
		
		Recipe recipeSelected=recipeService.findRecipeById(recipeId);
		Category categorySelected= categoryRepository.findCategoryByName(category.getName());
		
		if(recipeSelected==null || categorySelected==null) {
			//return false;
			System.out.println("<-----------------------------------------------------------------------" + categorySelected + " ------------------------------------------>");
			System.out.println("<-----------------------------------------------------------------------" + recipeSelected + " ------------------------------------------>");
			return "false";
		}
		
		
		
		
		CategoryRecipe categoryRecipeToRemove = null;
		categoryRecipeToRemove = categoryRecipeRepository.findCategoryRecipeByRecipeIdAndCategoryId(recipeId,categorySelected.getId());		
		
		if(categoryRecipeToRemove==null) {
			return "false";
		}
			
		
//		Category lookForIdOfCategorySelected= categorySelected.getId();
		
		
		categoryRecipeRepository.delete(categoryRecipeToRemove);		
		System.out.println("<-----------------------------------------------------------------------" + categoryRecipeToRemove + " ------------------------------------------>");
//		return true;
		return "was revoved"+categoryRecipeToRemove;
		
	}






}
