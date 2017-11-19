package com.academy.recipes.spring_course.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.academy.recipes.spring_course.model.enums.UnitMeasures;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingredient {

	@Id
	protected int id;
	
	protected int ingredientAmout;
	
	@Enumerated(EnumType.STRING)
	protected UnitMeasures unitMeasures;
	
	@OneToMany
	@JoinColumn(name="id")
	protected Recipe recipe;;
	
}
