package com.cg.jpa.lab1.sevices;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.cg.jpa.lab1.bean.Author;

public interface AuthorService {

	public void addAuthor(Author author);
	
	public Author getAuthor(int id);
	
	public void deleteAuthor(int id);
	
	public void updateAuthor(int id, Author author);
	
	public List<Author> getAuthors();
}
