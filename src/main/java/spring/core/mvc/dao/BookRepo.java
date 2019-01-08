package spring.core.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import spring.core.mvc.model.Book;

@Transactional
@Repository
public class BookRepo {

	@PersistenceContext
	EntityManager manager;

	@Transactional
	public boolean addBook(Book book) {
		manager.persist(book);
		return true;

	}

	@Transactional
	public boolean deleteBook(long refid) {

		Book book = manager.find(Book.class, refid);
		manager.remove(book);
		return true;

	}

	@Transactional
	public List<Book> getAllBooks() {
		String sqlquery = "select b from Book b";
		Query hquery = manager.createQuery(sqlquery);
		@SuppressWarnings("unchecked")
		List<Book> allbooks = hquery.getResultList();
		return allbooks;
	}

	@Transactional
	public Book getBook(long refid) {
		Book book = manager.find(Book.class, refid);
		return book;

	}
}
