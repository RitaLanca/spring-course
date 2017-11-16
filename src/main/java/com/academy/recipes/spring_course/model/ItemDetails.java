package com.academy.recipes.spring_course.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.academy.recipes.spring_course.model.enums.UnitMeasures;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected String description;
	
	@Enumerated(EnumType.STRING)
	protected UnitMeasures unitMeasures;
	
	@OneToOne
	@JoinColumn(name="id")
	@MapsId
	protected Item item;
	
}
