package com.academy.recipes.spring_course.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected String name;
	
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY)
	protected List<CategoryRecipe> recipesInCategory;
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", recipesInCategory=" + recipesInCategory + "]";
	}

}
