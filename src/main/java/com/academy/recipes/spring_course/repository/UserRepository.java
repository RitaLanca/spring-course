package com.academy.recipes.spring_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.recipes.spring_course.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
	
}
