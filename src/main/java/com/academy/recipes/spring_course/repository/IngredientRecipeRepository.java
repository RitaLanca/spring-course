package com.academy.recipes.spring_course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academy.recipes.spring_course.model.IngredientRecipe;

public interface IngredientRecipeRepository extends JpaRepository<IngredientRecipe, Long> {

	@Query("Select ir From IngredientRecipe ir where ir.recipe.id=:recipeId and ir.ingredient.id=:ingredientId ")
	IngredientRecipe findIngredientRecipeByRecipeIdAndIngredientId(@Param("recipeId") Long recipeId,@Param("ingredientId") Long id);
	
	@Query("Select ir From IngredientRecipe ir join fetch ir.recipe r join fetch ir.ingredient i")
	List<IngredientRecipe> findAll();

}
