package com.academy.recipes.spring_course.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.academy.recipes.spring_course.model.enums.UnitMeasures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IngredientRecipe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@ManyToOne
	@JoinColumn(name="ingredient_id") //nome da coluna que corresponde ao linked table
	protected Ingredient ingredient;
	
	@ManyToOne
	@JoinColumn(name="recipe_id")
	protected Recipe recipe;
	
	protected int quantity;
	
	@Enumerated(EnumType.STRING)
	protected UnitMeasures unitMeasure;
	
	public IngredientRecipe(Ingredient ingredient, Recipe recipe) {
		this.ingredient = ingredient;
		this.recipe = recipe;
	}
		
	public IngredientRecipe(Ingredient ingredient, Recipe recipe, int quantity, UnitMeasures unitMeasure) {
		this.ingredient = ingredient;
		this.recipe = recipe;
		this.quantity = quantity;
		this.unitMeasure = unitMeasure;
	}

	public IngredientRecipe(int quantity, UnitMeasures unitMeasure) {
		super();
		this.quantity = quantity;
		this.unitMeasure = unitMeasure;
	}

	@Override
	public String toString() {
		return "IngredientRecipe [ingredient=" + ingredient + ", recipe=" + recipe + ", quantity=" + quantity
				+ ", unitMeasure=" + unitMeasure + "]";
	}
	
	

	
}
