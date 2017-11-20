package com.academy.recipes.spring_course.service.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.academy.recipes.spring_course.model.Author;


public interface AuthorService  {
	
	Author registerAuthor(Author author);
	
	Author updateAuthor(Long id, Author author);
	
	Author findAuthorByName(String name);
	
	void deleteAuthor(Long id);
	
	List<Author> findAll();
	
	
	
	
}
