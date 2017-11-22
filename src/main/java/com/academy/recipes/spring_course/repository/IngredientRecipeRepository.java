package com.academy.recipes.spring_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.recipes.spring_course.model.IngredientRecipe;

public interface IngredientRecipeRepository extends JpaRepository<IngredientRecipe, Long> {

}
