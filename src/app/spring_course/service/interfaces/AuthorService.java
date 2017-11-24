package com.academy.recipes.spring_course.service.interfaces;


import java.util.List;

import com.academy.recipes.spring_course.model.Author;


public interface AuthorService  {
	
	Author registerAuthor(Author author);
	
	Author updateAuthor(Long id, Author author);
	
	List<Author> findAuthorByName(String name);
	
	Author findAuthorById(Long id);
	
	void deleteAuthor(Long id);
	
	List<Author> findAll();

	
	
	
	
	
}
