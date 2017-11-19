package com.academy.recipes.spring_course.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected String name;
	
	protected String description;
	
	protected int servings;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	protected Author author;
	
}
