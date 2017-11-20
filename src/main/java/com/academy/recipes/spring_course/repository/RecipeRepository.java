package com.academy.recipes.spring_course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	@Query("Select r From Recipe r where r.name Like %:name% ")
	List<Recipe> findByName(@Param("name") String name);
	
//	@Query("(Select r.name From Author au " +
//	 "inner join au.recipe r " +
//	 "where au.name = :authorName OR au.surname= :authorName")
//	List<Recipe> findByAuthor(@Param("name") String authorName);
	
	List<Recipe> findByAuthor(Author author);
	
	}
