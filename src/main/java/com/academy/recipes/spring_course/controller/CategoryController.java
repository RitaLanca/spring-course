package com.academy.recipes.spring_course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.academy.recipes.spring_course.model.Category;
import com.academy.recipes.spring_course.service.interfaces.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("")
	public Category createCategoryLable (@RequestBody Category category) {
		return categoryService.createCategoryLable(category);
	}
	
	@PostMapping("/labels")
	public Boolean addCategoryToRecipe (@RequestParam("id") Long recipeId,@RequestBody Category category) {
		return categoryService.addCategoryToRecipe(recipeId, category);
	}

	@DeleteMapping("/labels")
	public Boolean removeCategoryToRecipe (@RequestParam("id") Long recipeId,@RequestBody Category category) {
		return categoryService.removeCategoryFromRecipe(recipeId, category);
	}
	
	@DeleteMapping("")
	public String removeCategoryLable (@RequestParam("id") Long categoryId) {
		return categoryService.eliminateCategoryLable(categoryId);
	}


}
