package com.academy.recipes.spring_course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryRecipe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	//@JsonManagedReference(value="category")
	protected Category category;
	
	@ManyToOne
	@JoinColumn(name="recipe_id")
	//@JsonManagedReference(value="categoryRecipe")
	protected Recipe recipe;

	public CategoryRecipe(Category category, Recipe recipe) {
		this.category = category;
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "CategoryRecipe [id=" + id + ", category=" + category + ", recipe=" + recipe + "]";
	}
	
	
}
