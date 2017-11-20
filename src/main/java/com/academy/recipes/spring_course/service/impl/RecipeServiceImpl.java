package com.academy.recipes.spring_course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.model.Recipe;
import com.academy.recipes.spring_course.repository.AuthorRepository;
import com.academy.recipes.spring_course.repository.RecipeRepository;
import com.academy.recipes.spring_course.service.interfaces.AuthorService;
import com.academy.recipes.spring_course.service.interfaces.RecipeService;

@Component
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private AuthorService authorService;
	
	@Override
	public String createRecipe(Recipe recipe, Long authorId) {
		Author createdBy= this.authorService.findAuthorById(authorId);
		recipe.setAuthor(createdBy);
		recipeRepository.saveAndFlush(recipe);
		
		System.out.println(recipe);
		
		if (recipe!=null)
			return "A new recipe was created";
		else
			return "It wasn't possible to create a new recipe";
	}

	@Override
	public List<Recipe> findRecipeByRecipeName(String recipeName) {
		
		return recipeRepository.findByName(recipeName);
	}

	@Override
	public List<Recipe> findRecipeByAuthor(String authorName) {
		
		Author author = authorService.findAuthorByName(authorName).get(0);
				
		return recipeRepository.findByAuthor(author) ;
		
	}
	
	@Override
	public List<Recipe> findRecipeByAuthorId(Long authorId) {
		
		Author author = authorService.findAuthorById(authorId);
		return recipeRepository.findByAuthor(author) ;
		
	}
	
}
