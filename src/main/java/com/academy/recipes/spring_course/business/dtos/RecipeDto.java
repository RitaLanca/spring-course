package com.academy.recipes.spring_course.business.dtos;

import java.util.List;


import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.model.CategoryRecipe;
import com.academy.recipes.spring_course.model.IngredientRecipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
	
	protected Long id;
	
	protected String name;
	
	protected String description;
	

	protected int servings;
	
	protected Author author;
	
	protected List<CategoryRecipe> recipesInCategory;
	
	protected List<IngredientRecipe> ingredientsInRecipe;

	
	public RecipeDto(String name, String description, int servings, Author author,
			List<IngredientRecipe> ingredientsInRecipe) {
		this.name = name;
		this.description = description;
		this.servings = servings;
		this.author = author;
		this.ingredientsInRecipe = ingredientsInRecipe;
	}
	
	
}
