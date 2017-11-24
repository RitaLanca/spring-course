package com.academy.recipes.spring_course.business.dtos;

import com.academy.recipes.spring_course.model.enums.UnitMeasures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientRecipeDto {

	String recipeName;
	String ingredientName;
	String description;
	int quantity;
	UnitMeasures unitMeasure;
}
