package com.academy.recipes.spring_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.academy.recipes.spring_course.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {

	Category findCategoryByName(String name);
	
	@Query("Select c from Category c where c.id=:categoryId")
	Category findCategoryById(@Param("categoryId") Long id);
	
	
}
