package com.academy.recipes.spring_course.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.academy.recipes.spring_course.model.CategoryRecipe;

@Repository
public interface CategoryRecipeRepository extends JpaRepository<CategoryRecipe, Long>{

	@Query("Select cr From CategoryRecipe cr where cr.recipe.id=:recipeId and cr.category.id=:categoryId ")
	CategoryRecipe findCategoryRecipeByRecipeIdAndCategoryId(@Param("recipeId") Long recipeId, @Param("categoryId") Long categoryId);
			
}
