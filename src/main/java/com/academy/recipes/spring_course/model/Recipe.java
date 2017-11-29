package com.academy.recipes.spring_course.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"},ignoreUnknown = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@NotNull
	protected String name;
	
	
	protected String description;
	
	@NotNull
	protected int servings;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="author_id")
	protected Author author;
	
	@JsonBackReference(value="categoryRecipe")
	@OneToMany(mappedBy="recipe", fetch=FetchType.LAZY)
	protected List<CategoryRecipe> recipesInCategory;
	
	@JsonBackReference(value="ingredientRecipe")
	@OneToMany(mappedBy="recipe", fetch=FetchType.LAZY)
	protected List<IngredientRecipe> ingredientsInRecipe;

	public Recipe(String name, int servings) {
		this.name = name;
		this.servings = servings;
	}
	
	public Recipe(String name, String description, int servings) {
		this.name = name;
		this.description= description;
		this.servings = servings;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", servings=" + servings
				+ ", author=" + author + "]";
	}
	
	
	
}
