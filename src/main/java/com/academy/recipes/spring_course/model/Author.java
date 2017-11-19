package com.academy.recipes.spring_course.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity  // This tells Hibernate to make a table out of this class

public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected String name;
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name +"]";
	}



	public Author(Long id, String name, Long age) {
		super();
		this.id = id;
		this.name = name;
	}
	

}

