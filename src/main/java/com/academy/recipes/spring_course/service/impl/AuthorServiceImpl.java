package com.academy.recipes.spring_course.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
		BeanUtils.copyProperties(author, existingAuthor);
		return authorRepository.saveAndFlush(existingAuthor);
		
	}

	@Override
	public Author findAuthorByName(String name) {
		authorRepository.findByName(name);
		return null;
	}

	@Override
	public void deleteAuthor() {
		// TODO Auto-generated method stub
		
	}

}
