package com.academy.recipes.spring_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academy.recipes.spring_course.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {

	Category findCategoryByName(String name);
	
	Category findCategoryById(Long id);
}
