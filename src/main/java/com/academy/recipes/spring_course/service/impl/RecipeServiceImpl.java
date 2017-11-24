package com.academy.recipes.spring_course.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academy.recipes.spring_course.business.dtos.RecipeDto;
import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.model.Recipe;
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
		
		if (recipe!=null) {
			return "A new recipe was created";
		} 
		return "It wasn't possible to create a new recipe";
		
	}

	@Override
	public List<Recipe> findRecipeByRecipeName(String recipeName) {
		
		return recipeRepository.findByName(recipeName);
	}

	@Override
	public List<Recipe> findRecipeByAuthorId(Long authorId) {
		
		Author author = authorService.findAuthorById(authorId);
				
		return recipeRepository.findByAuthor(author) ;
		
	}

	@Override
	public String deleteRecipe(Long recipeId) {
		String result="";
		try {
			
			if(recipeRepository.exists(recipeId)) {
				recipeRepository.delete(recipeId);	
				result="Recipe was successfully deleted";
			} else
				result="Recipe doesn´t exist";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public Recipe findRecipeById(Long recipeId) {
		return recipeRepository.getOne(recipeId);
		 
	}

	@Override
	public Recipe updateRecipe(Long recipeId, Recipe recipe) {
		Recipe recipeToUpdate=recipeRepository.findOne(recipeId);
		
		if(recipe.getName()!=null)
			recipeToUpdate.setName(recipe.getName());
		
		if(recipe.getDescription()!=null)
		recipeToUpdate.setDescription(recipe.getDescription());
		
		Integer servingsToUpdate=recipe.getServings();
		if(servingsToUpdate!=null)
			recipeToUpdate.setServings(servingsToUpdate);
		
		return recipeRepository.save(recipeToUpdate);
		
/*This code is an alternative code for update recipe method	
*		Recipe existingRecipe = recipeRepository.findOne(recipeId);
*		BeanUtils.copyProperties(existingRecipe,recipe);
*		return recipeRepository.saveAndFlush(existingRecipe);
*/		
	
	}

	@Override
	public List<RecipeDto> findAllRecipes() {
		List<Recipe> recipes= recipeRepository.findAll();
		List<RecipeDto> recipeDtoList= new ArrayList<RecipeDto>();
		
		
		for(Recipe recipe: recipes) {
			recipeDtoList.add(new RecipeDto(recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getServings(),recipe.getAuthor(), recipe.getRecipesInCategory(), recipe.getIngredientsInRecipe()));
		}
		
		return recipeDtoList;
	}
}
