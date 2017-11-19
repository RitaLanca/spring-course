package com.academy.recipes.spring_course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academy.recipes.spring_course.model.Author;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findByName(String name);
	
	@Query("Select au From Author au where au.name Like %:name% ")
	Author findAuthoreByName(@Param("name") String name);
	
	
}
