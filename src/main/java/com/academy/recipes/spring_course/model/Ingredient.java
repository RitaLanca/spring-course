package com.academy.recipes.spring_course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingredient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected String name;
	
}
