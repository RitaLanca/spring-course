package com.academy.recipes.spring_course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity  // This tells Hibernate to make a table out of this class
@NoArgsConstructor
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected String name;
	
	protected String surname;
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name +"surname " + surname +"]";
	}

	public Author(Long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname= surname;
	}
	

}

