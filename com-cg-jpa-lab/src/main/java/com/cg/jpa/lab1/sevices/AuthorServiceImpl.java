package com.cg.jpa.lab1.sevices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.jpa.lab1.bean.Author;
import com.cg.jpa.lab1.utility.JPAUtil;

/**
 * 
 * @author mashivha
 *
 */
public class AuthorServiceImpl implements AuthorService {
	/**
	 * @param Author Class object to be stored in DB.
	 * This method stores Author object into DB
	 */
	public void addAuthor(Author author) {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction etransaction = emanager.getTransaction();
		etransaction.begin();
		emanager.persist(author);
		etransaction.commit();
		emanager.close();
	}

	/**
	 * @return Author Class Object
	 * @param int typed id
	 * This method returns Author object with matching id from DB
	 */
	public Author getAuthor(int id) {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		Author author = emanager.find(Author.class, id);
		emanager.close();
		return author;
	}

	/**
	 * @param int typed id
	 * This method deletes Author object with matching id from DB
	 */
	public void deleteAuthor(int id) {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction etransaction = emanager.getTransaction();
		etransaction.begin();
		Author a = emanager.find(Author.class, id);
		emanager.remove(emanager.contains(a) ? a : emanager.merge(a));
		emanager.getTransaction().commit();
		emanager.close();
	}
	
	/**
	 * @param int typed id 
	 * @param Author typed author
	 * This method update Author object with matching id into DB
	 */
	public void updateAuthor(int id, Author author) {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction etransaction = emanager.getTransaction();
		etransaction.begin();
		Author temp = emanager.find(Author.class, id);
		temp.setFirstName(author.getFirstName());
		temp.setLastName(author.getLastName());
		temp.setMiddleName(author.getMiddleName());
		temp.setPhoneNo(author.getPhoneNo());
		etransaction.commit();
		emanager.close();
	}
	
	/**
	 * @return list of typed Author
	 * This method returns all object of Author from DB
	 */
	public List<Author> getAuthors() {
		EntityManager emanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<Author> list = emanager.createQuery("from Author").getResultList();
		emanager.close();
		return list;
		
	}

}
