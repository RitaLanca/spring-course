package com.academy.recipes.spring_course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	public Recipe(String name, int servings) {
		this.name = name;
		this.servings = servings;
	}
	
	
}
