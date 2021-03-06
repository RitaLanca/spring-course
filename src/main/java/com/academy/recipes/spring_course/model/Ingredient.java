package com.academy.recipes.spring_course.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected String name;
	
	@JsonBackReference(value="ingredient")
	@OneToMany(mappedBy="ingredient", fetch=FetchType.LAZY, cascade= CascadeType.REMOVE)
	protected List<IngredientRecipe> ingredientsInRecipe;

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + "]";
	}

}
