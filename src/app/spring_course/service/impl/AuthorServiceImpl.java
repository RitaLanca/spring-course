package com.academy.recipes.spring_course.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.repository.AuthorRepository;
import com.academy.recipes.spring_course.service.interfaces.AuthorService;

@Component
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Author registerAuthor(Author author) {
		
		 
		return authorRepository.saveAndFlush(author);
		
	}

	
	@Override
	public Author updateAuthor( Long id, Author author) {
		Author existingAuthor = authorRepository.findOne(id);
		BeanUtils.copyProperties(existingAuthor,author);
		return authorRepository.saveAndFlush(existingAuthor);
		
	}

	@Override
	public List<Author> findAuthorByName(String name) {
		return authorRepository.findAuthorByName(name);
		 
	}
	
	@Override
	public Author findAuthorById(Long id) {
		return authorRepository.findOne(id);
		 
	}

	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.delete(id);

	}

}
